import { Component, OnInit } from '@angular/core';
import { Coleccion } from 'src/app/models/coleccion';
import { ColeccionService } from 'src/app/services/coleccion.service';

@Component({
  selector: 'app-colecciones',
  templateUrl: './colecciones.component.html'
})
export class ColeccionesComponent implements OnInit {

  titulo:string='Listado de colecciones'
  lista: Coleccion[] = [];
  constructor(private service: ColeccionService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(coleccion:Coleccion):void{
    if(confirm(`Seguro de eliminar a ${coleccion.nombre_coleccion}?`)){
      this.service.eliminar(coleccion.id_coleccion).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==coleccion);
        alert(`Coleccion ${coleccion.nombre_coleccion} eliminado con exito!`);
      });
    }
  }
}
