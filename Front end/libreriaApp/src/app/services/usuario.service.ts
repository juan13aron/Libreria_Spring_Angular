import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlEndPoint:string = 'http://localhost:8090/api/usuario';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Usuario>{
    return this.http.get<Usuario>(`${this.urlEndPoint}/${id}`)
  }

  crear(Usuario:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(this.urlEndPoint,Usuario,{headers:this.httpHeaders});
  }

  modificar(Usuario:Usuario):Observable<Usuario>{
    return this.http.put<Usuario>(`${this.urlEndPoint}/${Usuario.id_usuario}`,Usuario,{headers:this.httpHeaders});
  }

  eliminar(id_usuario:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_usuario}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
  
}

