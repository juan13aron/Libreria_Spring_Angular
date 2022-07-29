import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-empleado-form',
  templateUrl: './empleado-form.component.html',
})
export class EmpleadoFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  empleado:Empleado = new Empleado();

  constructor(private service:EmpleadoService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.empleado).subscribe(empleado =>{
      alert(`Empleado ${empleado.nombre_empleado} creado con exito!`);
      this.router.navigate(['/empleados']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_empleado = params['id_empleado'];
      if(id_empleado) {
        this.service.ver(id_empleado).subscribe((empleado) => this.empleado = empleado);
      }
    });
  }

  modificar(){
    this.service.modificar(this.empleado).subscribe(empleado =>{
      alert(`Empleado ${empleado.nombre_empleado} actualizado con exito!`);
      this.router.navigate(['/empleados']);
    });
  }

}
