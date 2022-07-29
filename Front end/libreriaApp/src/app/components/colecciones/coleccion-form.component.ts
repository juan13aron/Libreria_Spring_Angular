import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Coleccion } from 'src/app/models/coleccion';
import { ColeccionService } from 'src/app/services/coleccion.service';

@Component({
  selector: 'app-coleccion-form',
  templateUrl: './coleccion-form.component.html',
})
export class ColeccionFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  coleccion:Coleccion = new Coleccion();

  constructor(private service:ColeccionService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.coleccion).subscribe(coleccion =>{
      alert(`Coleccion ${coleccion.nombre_coleccion} creado con exito!`);
      this.router.navigate(['/colecciones']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_coleccion = params['id_coleccion'];
      if(id_coleccion) {
        this.service.ver(id_coleccion).subscribe((coleccion) => this.coleccion = coleccion);
      }
    });
  }

  modificar(){
    this.service.modificar(this.coleccion).subscribe(coleccion =>{
      alert(`Coleccion ${this.coleccion.nombre_coleccion} actualizado con exito!`);
      this.router.navigate(['/colecciones']);
    });
  }

}
