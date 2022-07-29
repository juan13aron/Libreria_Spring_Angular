import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Materia } from '../models/materia';

@Injectable({
  providedIn: 'root'
})
export class MateriaService {

  private urlEndPoint:string = 'http://localhost:8090/api/materia';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Materia[]>{
    return this.http.get<Materia[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Materia>{
    return this.http.get<Materia>(`${this.urlEndPoint}/${id}`)
  }

  crear(Materia:Materia):Observable<Materia>{
    return this.http.post<Materia>(this.urlEndPoint,Materia,{headers:this.httpHeaders});
  }

  modificar(Materia:Materia):Observable<Materia>{
    return this.http.put<Materia>(`${this.urlEndPoint}/${Materia.id_materia}`,Materia,{headers:this.httpHeaders});
  }

  eliminar(id_materia:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_materia}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
