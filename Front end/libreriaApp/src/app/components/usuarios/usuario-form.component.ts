import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
})
export class UsuarioFormComponent implements OnInit {

  titulo:string = "Formulario de Usuario";
  usuario:Usuario = new Usuario();

  constructor(private service:UsuarioService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.editar();
  }

  crear(){
    this.service.crear(this.usuario).subscribe(usuario =>{
      alert(`Usuario ${usuario.nombre_usuario} creado con exito!`);
      this.router.navigate(['/usuarios']);
    });
  }

  editar():void{
    this.route.params.subscribe(params => {
      let id_usuario = params['id_usuario'];
      if(id_usuario) {
        this.service.ver(id_usuario).subscribe((usuario) => this.usuario = usuario);
      }
    });
  }

  modificar(){
    this.service.modificar(this.usuario).subscribe(usuario =>{
      alert(`Usuario ${usuario.nombre_usuario} actualizado con exito!`);
      this.router.navigate(['/usuarios']);
    });
  }
}
