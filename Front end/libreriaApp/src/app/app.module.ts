import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { LayoutModule } from './layout/layout.module';
import { HttpClientModule} from '@angular/common/http';

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
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
