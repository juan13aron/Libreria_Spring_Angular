import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  titulo:string="Bienvenido a la Libreria"
  constructor() { }

  ngOnInit(): void {
  }

}
