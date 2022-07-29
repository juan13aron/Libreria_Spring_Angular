import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Autor } from '../models/autor';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  private urlEndPoint:string = 'http://localhost:8090/api/autor';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Autor[]>{
    return this.http.get<Autor[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Autor>{
    return this.http.get<Autor>(`${this.urlEndPoint}/${id}`)
  }

  crear(Autor:Autor):Observable<Autor>{
    return this.http.post<Autor>(this.urlEndPoint,Autor,{headers:this.httpHeaders});
  }

  modificar(Autor:Autor):Observable<Autor>{
    return this.http.put<Autor>(`${this.urlEndPoint}/${Autor.id_autor}`,Autor,{headers:this.httpHeaders});
  }

  eliminar(id_autor:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_autor}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
