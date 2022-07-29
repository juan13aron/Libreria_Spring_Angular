import { Component, OnInit } from '@angular/core';
import { Prestamo } from 'src/app/models/prestamo';
import { PrestamoService } from 'src/app/services/prestamo.service';

@Component({
  selector: 'app-prestamos',
  templateUrl: './prestamos.component.html'
})
export class PrestamosComponent implements OnInit {

  titulo:string='Listado de prestamos'
  lista: Prestamo[]=[];
  constructor(private service: PrestamoService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(prestamo:Prestamo):void{
    if(confirm(`Seguro de eliminar a ${prestamo.nombre_prestamo}?`)){
      this.service.eliminar(prestamo.id_prestamo).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==prestamo);
        alert(`Usuario ${prestamo.nombre_prestamo} eliminado con exito!`);
      });
    }
  }
}
