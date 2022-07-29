import { Component, OnInit } from '@angular/core';
import { Genero } from 'src/app/models/genero';
import { GeneroService } from 'src/app/services/genero.service';

@Component({
  selector: 'app-generos',
  templateUrl: './generos.component.html'
})
export class GenerosComponent implements OnInit {

  titulo:string='Listado de generos'
  lista: Genero[]=[];
  constructor(private service: GeneroService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(genero:Genero):void{
    if(confirm(`Seguro de eliminar a ${genero.nombre_genero}?`)){
      this.service.eliminar(genero.id_genero).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==genero);
        alert(`Genero ${genero.nombre_genero} eliminado con exito!`);
      });
    }
  }
}
