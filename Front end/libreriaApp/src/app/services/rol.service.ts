import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Rol } from '../models/rol';

@Injectable({
  providedIn: 'root'
})

export class RolService {

  private urlEndPoint:string = 'http://localhost:8090/api/rol';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Rol[]>{
    return this.http.get<Rol[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Rol>{
    return this.http.get<Rol>(`${this.urlEndPoint}/${id}`)
  }

  crear(Rol:Rol):Observable<Rol>{
    return this.http.post<Rol>(this.urlEndPoint,Rol,{headers:this.httpHeaders});
  }

  modificar(Rol:Rol):Observable<Rol>{
    return this.http.put<Rol>(`${this.urlEndPoint}/${Rol.id_rol}`,Rol,{headers:this.httpHeaders});
  }

  eliminar(id_rol:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_rol}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
  
}
