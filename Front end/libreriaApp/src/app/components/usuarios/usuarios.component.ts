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

}
