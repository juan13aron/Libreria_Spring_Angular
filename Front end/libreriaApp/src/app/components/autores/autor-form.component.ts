import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Autor } from 'src/app/models/autor';
import { AutorService } from 'src/app/services/autor.service';

@Component({
  selector: 'app-autor-form',
  templateUrl: './autor-form.component.html',
})
export class AutorFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  autor:Autor = new Autor();

  constructor(private service:AutorService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.autor).subscribe(autor =>{
      alert(`Autor ${autor.nombre_autor} creado con exito!`);
      this.router.navigate(['/autores']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_autor = params['id_autor'];
      if(id_autor) {
        this.service.ver(id_autor).subscribe((autor) => this.autor = autor);
      }
    });
  }

  modificar(){
    this.service.modificar(this.autor).subscribe(autor =>{
      alert(`Autor ${autor.nombre_autor} actualizado con exito!`);
      this.router.navigate(['/autores']);
    });
  }
}
