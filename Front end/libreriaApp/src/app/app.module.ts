import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { LayoutModule } from './layout/layout.module';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AutoresComponent } from './components/autores/autores.component';
import { ColeccionesComponent } from './components/colecciones/colecciones.component';
import { EditorialesComponent } from './components/editoriales/editoriales.component';
import { EmpleadosComponent } from './components/empleados/empleados.component';
import { EstadosComponent } from './components/estados/estados.component';
import { GenerosComponent } from './components/generos/generos.component';
import { MateriasComponent } from './components/materias/materias.component';
import { PrestamosComponent } from './components/prestamos/prestamos.component';
import { RolesComponent } from './components/roles/roles.component';
import { TipoColeccionesComponent } from './components/tipo-colecciones/tipo-colecciones.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

import { HomeComponent } from './components/home/home.component';
import { UsuarioFormComponent } from './components/usuarios/usuario-form.component';
import { RolFormComponent } from './components/roles/rol-form.component';
import { PrestamoFormComponent } from './components/prestamos/prestamo-form.component';
import { MateriaFormComponent } from './components/materias/materia-form.component';
import { GeneroFormComponent } from './components/generos/genero-form.component';
import { EstadoFormComponent } from './components/estados/estado-form.component';
import { EmpleadoFormComponent } from './components/empleados/empleado-form.component';
import { EditorialFormComponent } from './components/editoriales/editorial-form.component';
import { ColeccionFormComponent } from './components/colecciones/coleccion-form.component';
import { AutorFormComponent } from './components/autores/autor-form.component';
import { TipoColeccionFormComponent } from './components/tipo-colecciones/tipo-coleccion-form.component';


@NgModule({
  declarations: [
    AppComponent,
    AutoresComponent,
    ColeccionesComponent,
    EditorialesComponent,
    EmpleadosComponent,
    EstadosComponent,
    GenerosComponent,
    MateriasComponent,
    PrestamosComponent,
    RolesComponent,
    TipoColeccionesComponent,
    UsuariosComponent,
    HomeComponent,
    UsuarioFormComponent,
    RolFormComponent,
    PrestamoFormComponent,
    MateriaFormComponent,
    GeneroFormComponent,
    EstadoFormComponent,
    EmpleadoFormComponent,
    EditorialFormComponent,
    ColeccionFormComponent,
    AutorFormComponent,
    TipoColeccionFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
