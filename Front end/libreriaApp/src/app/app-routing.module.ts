import { Component, NgModule } from '@angular/core';
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

import { UsuarioFormComponent } from './components/usuarios/usuario-form.component';
import { TipoColeccionFormComponent } from './components/tipo-colecciones/tipo-coleccion-form.component';
import { RolFormComponent } from './components/roles/rol-form.component';
import { PrestamoFormComponent } from './components/prestamos/prestamo-form.component';
import { MateriaFormComponent } from './components/materias/materia-form.component';
import { GeneroFormComponent } from './components/generos/genero-form.component';
import { EstadoFormComponent } from './components/estados/estado-form.component';
import { EmpleadoFormComponent } from './components/empleados/empleado-form.component';
import { EditorialFormComponent } from './components/editoriales/editorial-form.component';
import { ColeccionFormComponent } from './components/colecciones/coleccion-form.component';
import { AutorFormComponent } from './components/autores/autor-form.component';

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
  {path: "home", component: HomeComponent},

  {path: "autores/form", component: AutorFormComponent},
  {path: "colecciones/form", component: ColeccionFormComponent},
  {path: "editoriales/form", component: EditorialFormComponent},
  {path: "empleados/form", component: EmpleadoFormComponent},
  {path: "estados/form", component: EstadoFormComponent},
  {path: "generos/form", component: GeneroFormComponent},
  {path: "materias/form", component: MateriaFormComponent},
  {path: "prestamos/form", component: PrestamoFormComponent },
  {path: "roles/form", component: RolFormComponent},
  {path: "tipocolecciones/form",component: TipoColeccionFormComponent},
  {path: "usuarios/form",component: UsuarioFormComponent },

  {path: "autores/form/:id_autor", component: AutorFormComponent},
  {path: "colecciones/form/:id_coleccion", component: ColeccionFormComponent},
  {path: "editoriales/form/:id_editorial", component: EditorialFormComponent},
  {path: "empleados/form/:id_empleado", component: EmpleadoFormComponent},
  {path: "estados/form/:id_estado", component: EstadoFormComponent},
  {path: "generos/form/:id_genero", component: GeneroFormComponent},
  {path: "materias/form/:id_materia", component: MateriaFormComponent},
  {path: "prestamos/form/:id_prestamo", component: PrestamoFormComponent},
  {path: "roles/form/:id_rol", component: RolFormComponent},
  {path: "tipocolecciones/form/:id_tipo_coleccion", component: TipoColeccionFormComponent},
  {path: "usuarios/form/:id_usuario", component: UsuarioFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
