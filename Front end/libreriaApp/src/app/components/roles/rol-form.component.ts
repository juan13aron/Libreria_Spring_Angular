import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Rol } from 'src/app/models/rol';
import { RolService } from 'src/app/services/rol.service';

@Component({
  selector: 'app-rol-form',
  templateUrl: './rol-form.component.html',
})
export class RolFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  rol:Rol = new Rol();

  constructor(private service:RolService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.rol).subscribe(rol =>{
      alert(`Rol ${rol.nombre_rol} creado con exito!`);
      this.router.navigate(['/roles']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_rol = params['id_rol'];
      if(id_rol) {
        this.service.ver(id_rol).subscribe((rol) => this.rol = rol);
      }
    });
  }

  modificar(){
    this.service.modificar(this.rol).subscribe(rol =>{
      alert(`Rol ${rol.nombre_rol} actualizado con exito!`);
      this.router.navigate(['/roles']);
    });
  }

}
