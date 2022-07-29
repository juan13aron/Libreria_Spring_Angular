import { Devolucion } from "./devolucion";

export class Prestamo {

    id_prestamo:number=0;
    nombre_prestamo:string="";
    fechaPrestamo:Date= new Date();
    descripcion:string="";
    id_devolucion:Devolucion[]=[];

}
