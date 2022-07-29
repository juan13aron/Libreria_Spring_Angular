import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Estado } from '../models/estado';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  private urlEndPoint:string = 'http://localhost:8090/api/estado';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Estado[]>{
    return this.http.get<Estado[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Estado>{
    return this.http.get<Estado>(`${this.urlEndPoint}/${id}`)
  }

  crear(Estado:Estado):Observable<Estado>{
    return this.http.post<Estado>(this.urlEndPoint,Estado,{headers:this.httpHeaders});
  }

  modificar(Estado:Estado):Observable<Estado>{
    return this.http.put<Estado>(`${this.urlEndPoint}/${Estado.id_estado}`,Estado,{headers:this.httpHeaders});
  }

  eliminar(id_estado:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_estado}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
