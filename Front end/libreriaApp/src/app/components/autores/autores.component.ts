import { Component, OnInit } from '@angular/core';
import { Autor } from 'src/app/models/autor';
import { AutorService } from 'src/app/services/autor.service';

@Component({
  selector: 'app-autores',
  templateUrl: './autores.component.html',
})
export class AutoresComponent implements OnInit {

  titulo:string='Listado de autores'
  lista: Autor[]=[];
  constructor(private service: AutorService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(autor:Autor):void{
    if(confirm(`Seguro de eliminar a ${autor.nombre_autor}?`)){
      this.service.eliminar(autor.id_autor).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==autor);
        alert(`Autor ${autor.nombre_autor} eliminado con exito!`);
      });
    }
  }
}
