import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Coleccion } from '../models/coleccion';

@Injectable({
  providedIn: 'root'
})
export class ColeccionService {

  private urlEndPoint:string = 'http://localhost:8090/api/coleccion';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Coleccion[]>{
    return this.http.get<Coleccion[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Coleccion>{
    return this.http.get<Coleccion>(`${this.urlEndPoint}/${id}`)
  }

  crear(Coleccion:Coleccion):Observable<Coleccion>{
    return this.http.post<Coleccion>(this.urlEndPoint,Coleccion,{headers:this.httpHeaders});
  }

  modificar(Coleccion:Coleccion):Observable<Coleccion>{
    return this.http.put<Coleccion>(`${this.urlEndPoint}/${Coleccion.id_coleccion}`,Coleccion,{headers:this.httpHeaders});
  }

  eliminar(id_coleccion:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_coleccion}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
