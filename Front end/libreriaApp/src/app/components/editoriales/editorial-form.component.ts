import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/services/editorial.service';

@Component({
  selector: 'app-editorial-form',
  templateUrl: './editorial-form.component.html',
})
export class EditorialFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  editorial:Editorial = new Editorial();

  constructor(private service:EditorialService, private router:Router , private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.editorial).subscribe(editorial =>{
      alert(`Editorial ${editorial.nombre_editorial} creado con exito!`);
      this.router.navigate(['/editoriales']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_editorial = params['id_editorial'];
      if(id_editorial) {
        this.service.ver(id_editorial).subscribe((editorial) => this.editorial = editorial);
      }
    });
  }

  modificar(){
    this.service.modificar(this.editorial).subscribe(editorial =>{
      alert(`Editorial ${editorial.nombre_editorial} actualizado con exito!`);
      this.router.navigate(['/editoriales']);
    });
  }

}
