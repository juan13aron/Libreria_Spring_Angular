import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-empleados',
  templateUrl: './empleados.component.html'
})
export class EmpleadosComponent implements OnInit {

  titulo:string='Listado de empleados'
  lista: Empleado[]=[];
  constructor(private service: EmpleadoService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(empleado:Empleado):void{
    if(confirm(`Seguro de eliminar a ${empleado.nombre_empleado}?`)){
      this.service.eliminar(empleado.id_empleado).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==empleado);
        alert(`Empleado ${empleado.nombre_empleado} eliminado con exito!`);
      });
    }
  }
}
