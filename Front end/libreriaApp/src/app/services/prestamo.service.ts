import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Prestamo } from '../models/prestamo';

@Injectable({
  providedIn: 'root'
})
export class PrestamoService {

  private urlEndPoint:string = 'http://localhost:8090/api/prestamo';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Prestamo[]>{
    return this.http.get<Prestamo[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Prestamo>{
    return this.http.get<Prestamo>(`${this.urlEndPoint}/${id}`)
  }

  crear(Prestamo:Prestamo):Observable<Prestamo>{
    return this.http.post<Prestamo>(this.urlEndPoint,Prestamo,{headers:this.httpHeaders});
  }

  modificar(Prestamo:Prestamo):Observable<Prestamo>{
    return this.http.put<Prestamo>(`${this.urlEndPoint}/${Prestamo.id_prestamo}`,Prestamo,{headers:this.httpHeaders});
  }

  eliminar(id_prestamo:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_prestamo}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
