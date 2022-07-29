import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Materia } from 'src/app/models/materia';
import { MateriaService } from 'src/app/services/materia.service';

@Component({
  selector: 'app-materia-form',
  templateUrl: './materia-form.component.html',
})
export class MateriaFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  materia:Materia = new Materia();

  constructor(private service:MateriaService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.materia).subscribe(materia =>{
      alert(`Materia ${materia.nombre_materia} creado con exito!`);
      this.router.navigate(['/materias']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_materia = params['id_materia'];
      if(id_materia) {
        this.service.ver(id_materia).subscribe((materia) => this.materia = materia);
      }
    });
  }

  modificar(){
    this.service.modificar(this.materia).subscribe(materia =>{
      alert(`Materia ${materia.nombre_materia} actualizado con exito!`);
      this.router.navigate(['/materias']);
    });
  }

}
