import { Component, OnInit } from '@angular/core';
import { Materia } from 'src/app/models/materia';
import { MateriaService } from 'src/app/services/materia.service';

@Component({
  selector: 'app-materias',
  templateUrl: './materias.component.html'
})
export class MateriasComponent implements OnInit {

  titulo:string='Listado de materias'
  lista: Materia[]=[];
  constructor(private service: MateriaService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(materia:Materia):void{
    if(confirm(`Seguro de eliminar a ${materia.nombre_materia}?`)){
      this.service.eliminar(materia.id_materia).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==materia);
        alert(`Usuario ${materia.nombre_materia} eliminado con exito!`);
      });
    }
  }

}
