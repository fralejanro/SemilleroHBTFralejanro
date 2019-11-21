import {PersonaDTO} from '../dto/persona.dto';
/**
 * @description Clase ProveedorDTO que contiene la informacion de un proveedor
 * 
 * @author Francisco Alejandro Hoyos Rojas<fralejanro@gmail.com>
 */
export class ProveedorDTO {

    /**
    * Atributo que define el id unico de un proveedor
    */
    public id: string;

    /**
    * Atributo que define la dirección de una persona
    */
    public direccion: string;

    /**
     * Atributo que define la fecha de contratación del proveedor
     */
    public fechaCreacion: Date;

    /**
     * Atributo que define si un proveedor esta activo o inactivo
     */
     public estado: String;

     /**
      * Atributo que define la persona que representa legalmente al proveedor
      */
     public personaDTO: PersonaDTO;

     /**
      * Atributo que define el monto del credito
      */
     public montoCredito: number;

}