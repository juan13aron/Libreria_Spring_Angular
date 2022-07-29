import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Genero } from '../models/genero';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {

  private urlEndPoint:string = 'http://localhost:8090/api/genero';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Genero[]>{
    return this.http.get<Genero[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Genero>{
    return this.http.get<Genero>(`${this.urlEndPoint}/${id}`)
  }

  crear(Genero:Genero):Observable<Genero>{
    return this.http.post<Genero>(this.urlEndPoint,Genero,{headers:this.httpHeaders});
  }

  modificar(Genero:Genero):Observable<Genero>{
    return this.http.put<Genero>(`${this.urlEndPoint}/${Genero.id_genero}`,Genero,{headers:this.httpHeaders});
  }

  eliminar(id_genero:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_genero}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }

}
