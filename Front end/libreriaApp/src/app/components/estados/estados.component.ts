import { Component, OnInit } from '@angular/core';
import { Estado } from 'src/app/models/estado';
import { EstadoService } from 'src/app/services/estado.service';

@Component({
  selector: 'app-estados',
  templateUrl: './estados.component.html'
})
export class EstadosComponent implements OnInit {

  titulo:string='Listado de estados'
  lista: Estado[]=[];
  constructor(private service: EstadoService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(estado:Estado):void{
    if(confirm(`Seguro de eliminar a ${estado.nombre_estado}?`)){
      this.service.eliminar(estado.id_estado).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==estado);
        alert(`Estado ${estado.nombre_estado} eliminado con exito!`);
      });
    }
  }
}
