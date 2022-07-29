import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html'
})
export class UsuariosComponent implements OnInit {

  titulo:string='Listado de usuarios'
  lista: Usuario[]=[];
  constructor(private service: UsuarioService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(usuario:Usuario):void{
    if(confirm(`Seguro de eliminar a ${usuario.nombre_usuario}?`)){
      this.service.eliminar(usuario.id_usuario).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==usuario);
        alert(`Usuario ${usuario.nombre_usuario} eliminado con exito!`);
      });
    }
  }
}
