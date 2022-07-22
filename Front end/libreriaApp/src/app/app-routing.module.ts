import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AutoresComponent } from './components/autores/autores.component';
import { ColeccionesComponent } from './components/colecciones/colecciones.component';
import { EditorialesComponent } from './components/editoriales/editoriales.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { EstadosComponent } from './components/estados/estados.component';
import { GenerosComponent } from './components/generos/generos.component';
import { HomeComponent } from './components/home/home.component';
import { MateriasComponent } from './components/materias/materias.component';
import { PrestamosComponent } from './components/prestamos/prestamos.component';
import { RolesComponent } from './components/roles/roles.component';
import { TipoColeccionesComponent } from './components/tipo-colecciones/tipo-colecciones.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

const routes: Routes = [

  {path: "autores", component: AutoresComponent},
  {path: "colecciones", component: ColeccionesComponent},
  {path: "editoriales", component: EditorialesComponent},
  {path: "empleados", component: EmpleadosComponent},
  {path: "estados", component: EstadosComponent},
  {path: "generos", component: GenerosComponent},
  {path: "materias", component: MateriasComponent},
  {path: "prestamos", component: PrestamosComponent},
  {path: "roles", component: RolesComponent},
  {path: "tipocolecciones", component: TipoColeccionesComponent},
  {path: "usuarios", component: UsuariosComponent},
  {path: "home", component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
