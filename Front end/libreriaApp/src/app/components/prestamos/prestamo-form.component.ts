import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Prestamo } from 'src/app/models/prestamo';
import { PrestamoService } from 'src/app/services/prestamo.service';

@Component({
  selector: 'app-prestamo-form',
  templateUrl: './prestamo-form.component.html',
})
export class PrestamoFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  prestamo:Prestamo = new Prestamo();

  constructor(private service:PrestamoService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.prestamo).subscribe(prestamo =>{
      alert(`Prestamo ${prestamo.nombre_prestamo} creado con exito!`);
      this.router.navigate(['/prestamos']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_prestamo = params['id_prestamo'];
      if(id_prestamo) {
        this.service.ver(id_prestamo).subscribe((prestamo) => this.prestamo = prestamo);
      }
    });
  }

  modificar(){
    this.service.modificar(this.prestamo).subscribe(prestamo =>{
      alert(`Prestamo ${prestamo.nombre_prestamo} actualizado con exito!`);
      this.router.navigate(['/prestamos']);
    });
  }
}
