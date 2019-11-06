import { Component, OnInit } from '@angular/core';
import { Libro } from './libro.model';

/**
 * @description  Componente gestionar libro, el cual se utiliza
 * para gestionar libros
 * 
 * @author Fancisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
 */
@Component({
    selector: 'gestionar-libro',
    templateUrl: './gestionar-libro-component.html',
    styleUrls: ['./gestionar-libro-component.css']
})

export class GestionarLibroComponent implements OnInit{

    /**
     * Atributo que representa la lista de libros
     */
    public libros: Array<Libro>;

    /**
     * Atributo que reprensenta un mensaje cuando se elimina un libro
     */
    public mensaje: string;


    /**
     * Constructor del componente
     */
    constructor(){

    }

    ngOnInit(){
        this.libros = new Array<Libro>();
        this.crearLibros(this.libros);
        this.mensaje = "";

    }

    /**
     * Método utilizado para crear y agregar libros a una lista de libros
     * @param libros lista donde se van a crear y agregar libros
     */
    public crearLibros(libros: Array<Libro>): void{
       let libro = new Libro(1,  "Rick y Morty", "Norma", 100, 10000, "Ryan Ridley", true,new Date("2013-01-01"),"Activo");
       libros.push(libro);
       libro = new Libro(2,  "Flash", "DC Comics", 200, 20000, "David Nutter", true,new Date("2014-02-01"),"Activo");
       libros.push(libro);
       libro = new Libro(3,  "Los espiritus de los muertos", "Planeta Comic", 300, 30000, "Edgar Allan Poe", true,new Date("2015-05-05"),"Inactivo");
       libros.push(libro);
       libro = new Libro(4,  "El misterio de Salem's Lo", "Libreria Nacional", 400, 40000, "Stephen King", true,new Date("2018-05-05"),"Activo");
       libros.push(libro);
       libro = new Libro(5,  "El gato negro", "Planeta Comic", 500, 30000, "Edgar Allan Poe", true,new Date("2010-01-01"),"Inactivo");
       libros.push(libro);
    }

    /**
     * Método utilizado para eliminar un libro por id
     * @param id id del libro a eliminar
     */
    public eliminarLibro(id: number): void{
        let libro: Libro;
        for (let index = 0; index < this.libros.length; index++) {
            libro = this.libros[index];
           if(libro.id == id){
            this.libros.splice(index,1);
            this.mensaje = "El libro " + libro.nombre + "fue eliminado";
            return;
           }
        }
        this.mensaje = "El libro con id 3 no existe";
    }
}