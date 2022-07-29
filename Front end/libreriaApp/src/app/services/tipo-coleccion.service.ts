import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TipoColeccion } from '../models/tipo-coleccion';

@Injectable({
  providedIn: 'root'
})
export class TipoColeccionService {

  private urlEndPoint:string = 'http://localhost:8090/api/tipocoleccion';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<TipoColeccion[]>{
    return this.http.get<TipoColeccion[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<TipoColeccion>{
    return this.http.get<TipoColeccion>(`${this.urlEndPoint}/${id}`)
  }

  crear(TipoColeccion:TipoColeccion):Observable<TipoColeccion>{
    return this.http.post<TipoColeccion>(this.urlEndPoint,TipoColeccion,{headers:this.httpHeaders});
  }

  modificar(TipoColeccion:TipoColeccion):Observable<TipoColeccion>{
    return this.http.put<TipoColeccion>(`${this.urlEndPoint}/${TipoColeccion.id_tipo_coleccion}`,TipoColeccion,{headers:this.httpHeaders});
  }

  eliminar(id_tipo_coleccion:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_tipo_coleccion}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
