import { Component, OnInit } from '@angular/core';
import { TipoColeccion } from 'src/app/models/tipo-coleccion';
import { TipoColeccionService } from 'src/app/services/tipo-coleccion.service';

@Component({
  selector: 'app-tipo-colecciones',
  templateUrl: './tipo-colecciones.component.html'
})
export class TipoColeccionesComponent implements OnInit {

  titulo:string='Listado de tipos de colecciones'
  lista: TipoColeccion[]=[];
  constructor(private service: TipoColeccionService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }
  public eliminar(tipocoleccion:TipoColeccion):void{
    if(confirm(`Seguro de eliminar a ${tipocoleccion.nombre_tipo_coleccion}?`)){
      this.service.eliminar(tipocoleccion.id_tipo_coleccion).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==tipocoleccion);
        alert(`Usuario ${tipocoleccion.nombre_tipo_coleccion} eliminado con exito!`);
      });
    }
  }
}
