import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Editorial } from '../models/editorial';

@Injectable({
  providedIn: 'root'
})
export class EditorialService {

  private urlEndPoint:string = 'http://localhost:8090/api/editorial';
  private httpHeaders = new HttpHeaders({ 'Content-Type':'application/json'});
  constructor(private http:HttpClient) { }

  listar(): Observable<Editorial[]>{
    return this.http.get<Editorial[]>(this.urlEndPoint);
  }

  ver(id: number): Observable<Editorial>{
    return this.http.get<Editorial>(`${this.urlEndPoint}/${id}`)
  }

  crear(Editorial:Editorial):Observable<Editorial>{
    return this.http.post<Editorial>(this.urlEndPoint,Editorial,{headers:this.httpHeaders});
  }

  modificar(Editorial:Editorial):Observable<Editorial>{
    return this.http.put<Editorial>(`${this.urlEndPoint}/${Editorial.id_editorial}`,Editorial,{headers:this.httpHeaders});
  }

  eliminar(id_editorial:number):Observable<void>{
    return this.http.delete<void>(`${this.urlEndPoint}/${id_editorial}`,{headers:this.httpHeaders});
  }

  listarPagina(page:string, size:string):Observable<any>{
    const params = new HttpParams()
    .set('page',page)
    .set('size',size);
    return this.http.get<any>(`${this.urlEndPoint}/pagina`,{params:params});
  }
}
