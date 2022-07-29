import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Estado } from 'src/app/models/estado';
import { EstadoService } from 'src/app/services/estado.service';

@Component({
  selector: 'app-estado-form',
  templateUrl: './estado-form.component.html',
})
export class EstadoFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  estado:Estado = new Estado();

  constructor(private service:EstadoService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.estado).subscribe(estado =>{
      alert(`Estado ${estado.nombre_estado} creado con exito!`);
      this.router.navigate(['/estados']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_estado = params['id_estado'];
      if(id_estado) {
        this.service.ver(id_estado).subscribe((estado) => this.estado = estado);
      }
    });
  }

  modificar(){
    this.service.modificar(this.estado).subscribe(estado =>{
      alert(`Estado ${estado.nombre_estado} actualizado con exito!`);
      this.router.navigate(['/estados']);
    });
  }
}
