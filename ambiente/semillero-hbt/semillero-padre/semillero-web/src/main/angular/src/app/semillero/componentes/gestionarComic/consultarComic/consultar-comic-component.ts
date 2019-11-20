import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormBuilder } from '@angular/forms';


/**
   * @description Componenete consultar comic, el cual se utiliza para visualizar los datos de un comic
   * 
   * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
   */
@Component({
    selector: 'consultar-comic',
    templateUrl: './consultar-comic-component.html',
    styleUrls: ['./consultar-comic-component.css']
})

export class ConsultarComicComponent implements OnInit {

    /**
    * Atributo que contiene los controles del formulario
    */
    public consultarComicForm: FormGroup;


    /**
     * Constructor del componente
     */
    constructor(private router: Router, private activatedRoute: ActivatedRoute, private fb: FormBuilder) {
        this.consultarComicForm = this.fb.group({
            nombre: [null],
            editorial: [null],
            tematica: [null],
            coleccion: [null],
            numeroPaginas: [null],
            precio: [null],
            autores: [null],
            color: [null]
        });
    }


    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    ngOnInit(): void {
        this.consultarComic();
    }


    /**
     * Metodo que permite consultar los datos de un Comic
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com> 
     */
    public consultarComic(): void {
        let datosComic = this.activatedRoute.snapshot.params;
        this.consultarComicForm.controls.nombre.setValue(datosComic.nombre);
        this.consultarComicForm.controls.editorial.setValue(datosComic.editorial);
        this.consultarComicForm.controls.tematica.setValue(datosComic.tematicaEnum[0].toUpperCase() + datosComic.tematicaEnum.substr(1).toLowerCase());
        this.consultarComicForm.controls.coleccion.setValue(datosComic.coleccion);
        this.consultarComicForm.controls.numeroPaginas.setValue(datosComic.numeroPaginas);
        this.consultarComicForm.controls.precio.setValue(datosComic.precio);
        this.consultarComicForm.controls.autores.setValue(datosComic.autores);
        this.consultarComicForm.controls.color.setValue(datosComic.color);
        this.consultarComicForm.controls.nombre.disable();
        this.consultarComicForm.controls.editorial.disable();
        this.consultarComicForm.controls.tematica.disable();
        this.consultarComicForm.controls.coleccion.disable();
        this.consultarComicForm.controls.numeroPaginas.disable();
        this.consultarComicForm.controls.precio.disable();
        this.consultarComicForm.controls.autores.disable();
        this.consultarComicForm.controls.color.disable();
        //        this.consultarComicForm.controls.color.enable(); para habilitar el campo

    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    get f() {
        return this.consultarComicForm.controls;
    }

    /**
  * @description Metodo encargado de direccionar al componente de gestionar comic
  * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
  */
    public navegarGestionarComic(): void {
        this.router.navigate(['gestionar-comic']);
    }


}


