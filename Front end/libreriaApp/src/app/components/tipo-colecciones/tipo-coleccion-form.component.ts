import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TipoColeccion } from 'src/app/models/tipo-coleccion';
import { TipoColeccionService } from 'src/app/services/tipo-coleccion.service';

@Component({
  selector: 'app-tipo-coleccion-form',
  templateUrl: './tipo-coleccion-form.component.html',
})
export class TipoColeccionFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  tipocoleccion:TipoColeccion = new TipoColeccion();

  constructor(private service:TipoColeccionService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.tipocoleccion).subscribe(tipocoleccion =>{
      alert(`Tipo coleccion  ${tipocoleccion.nombre_tipo_coleccion} creado con exito!`);
      this.router.navigate(['/tipocolecciones']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_tipo_coleccion = params['id_tipo_coleccion'];
      if(id_tipo_coleccion) {
        this.service.ver(id_tipo_coleccion).subscribe((tipocoleccion) => this.tipocoleccion = tipocoleccion);
      }
    });
  }

  modificar(){
    this.service.modificar(this.tipocoleccion).subscribe(tipocoleccion =>{
      alert(`Tipo Coleccion ${tipocoleccion.nombre_tipo_coleccion} actualizado con exito!`);
      this.router.navigate(['/tipocolecciones']);
    });
  }

}
