import { Rol } from "./rol";

export class Empleado {

    id_empleado:number=0;
    nombre_empleado:string="";
    telefono_empleado:number=0;
    correo_empleado:string="";
    clave_empleado:string="";
    id_rol:Rol[]=[];
    
}
