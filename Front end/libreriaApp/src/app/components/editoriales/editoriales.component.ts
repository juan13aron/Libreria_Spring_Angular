import { Component, OnInit } from '@angular/core';
import { Editorial } from 'src/app/models/editorial';
import { EditorialService } from 'src/app/services/editorial.service';

@Component({
  selector: 'app-editoriales',
  templateUrl: './editoriales.component.html'
})
export class EditorialesComponent implements OnInit {

  titulo:string='Listado de editoriales'
  lista: Editorial[]=[];
  constructor(private service: EditorialService) { }

  ngOnInit(): void {
    this.service.listar().subscribe(lista => this.lista = lista);
  }

  public eliminar(editorial:Editorial):void{
    if(confirm(`Seguro de eliminar a ${editorial.nombre_editorial}?`)){
      this.service.eliminar(editorial.id_editorial).subscribe(() =>{
        this.lista = this.lista.filter(u => u !==editorial);
        alert(`Editorial ${editorial.nombre_editorial} eliminado con exito!`);
      });
    }
  }

}
