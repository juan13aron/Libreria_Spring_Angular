import { Component, OnInit } from '@angular/core';
import { Rol } from 'src/app/models/rol';
import { RolService } from 'src/app/services/rol.service';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html'
})
export class RolesComponent implements OnInit {

  titulo: string='Listado de Roles'
  lista: Rol[]=[];
  constructor(private service: RolService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista=lista);
  }
  public eliminar(rol:Rol):void{
    if(confirm(`Seguro de eliminar a ${rol.nombre_rol}?`)){
      this.service.eliminar(rol.id_rol).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==rol);
        alert(`Rol ${rol.nombre_rol} eliminado con exito!`);
      });
    }
  }
}
