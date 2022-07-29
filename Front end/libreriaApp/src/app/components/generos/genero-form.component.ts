import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Genero } from 'src/app/models/genero';
import { GeneroService } from 'src/app/services/genero.service';

@Component({
  selector: 'app-genero-form',
  templateUrl: './genero-form.component.html',
})
export class GeneroFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  genero:Genero = new Genero();

  constructor(private service:GeneroService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.genero).subscribe(genero =>{
      alert(`Genero ${genero.nombre_genero} creado con exito!`);
      this.router.navigate(['/generos']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_genero = params['id_genero'];
      if(id_genero) {
        this.service.ver(id_genero).subscribe((genero) => this.genero = genero);
      }
    });
  }

  modificar(){
    this.service.modificar(this.genero).subscribe(genero =>{
      alert(`Genero ${genero.nombre_genero} actualizado con exito!`);
      this.router.navigate(['/generos']);
    });
  }

}
