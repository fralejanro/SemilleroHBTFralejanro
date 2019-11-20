
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarComicService } from '../../services/gestionar.comic.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contendra la posición del comic que se elija en la lista de comics
     */
    public posicionComic: number;

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm: FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics: Array<ComicDTO>;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    constructor(private fb: FormBuilder,
        private router: Router,
        private gestionarComicService: GestionarComicService) {
        this.gestionarComicForm = this.fb.group({
            nombre: [null, Validators.required],
            editorial: [null, Validators.required],
            tematica: [null, Validators.required],
            coleccion: [null, Validators.required],
            numeroPaginas: [null, Validators.required],
            precio: [null, Validators.required],
            autores: [null, Validators.required],
            color: [null, Validators.required]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.posicionComic = -1;
        this.comic = new ComicDTO();
        this.listaComics = new Array<ComicDTO>();
        this.consultarComics();
    }


    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    public crearActualizarComic(): void {
        this.submitted = true;
        if (this.gestionarComicForm.invalid) {
            return;
        }
        if (this.posicionComic == -1) {
            this.crearComic();
        } else {
            let comicActualizar: ComicDTO;
            comicActualizar = this.listaComics[this.posicionComic];
            comicActualizar.nombre = this.gestionarComicForm.controls.nombre.value;
            comicActualizar.editorial = this.gestionarComicForm.controls.editorial.value;
            comicActualizar.tematicaEnum = this.gestionarComicForm.controls.tematica.value;
            comicActualizar.coleccion = this.gestionarComicForm.controls.coleccion.value;
            comicActualizar.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
            comicActualizar.precio = this.gestionarComicForm.controls.precio.value;
            comicActualizar.autores = this.gestionarComicForm.controls.autores.value;
            comicActualizar.color = this.gestionarComicForm.controls.color.value;
            this.listaComics.splice(this.posicionComic, 1, comicActualizar);
            this.posicionComic = -1;

        }
        this.limpiarFormulario();


    }

    /**
         * @description Metodo que permite editar un comic
         * @param comic comic que será editado
         * @param posicionComicLista posicion del comic en la lista de comics
         * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
         */
    public editarComic(comic: ComicDTO, posicionComicLista: number): void {
        this.posicionComic = posicionComicLista;
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematicaEnum);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
    }

    /**
         * @description Metodo que permite limpiar los campos del formulario
         * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
         */
    private limpiarFormulario(): void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }

    /**
     * @description Metodo que permite eliminar un comic
     * @param idComic posicion del comic en la lista de comics
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    public eliminarComic(idComic: number): void {
        this.gestionarComicService.eliminarComic(idComic).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
            }
            console.log(resultadoDTO.mensajeEjecucion);
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    get f() {
        return this.gestionarComicForm.controls;
    }

    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    public consultarComics(): void {
        this.gestionarComicService.consultarComics().subscribe(listaComics => {
            this.listaComics = listaComics;
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    public crearComic(): void {
        this.comic = new ComicDTO();
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematicaEnum = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;
        this.comic.estadoEnum = "INACTIVO";

        this.gestionarComicService.crearComic(this.comic).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                this.consultarComics();
                this.limpiarFormulario();
            }else{
                console.log(resultadoDTO.mensajeEjecucion);
            }
        }, error => {
            console.log(error);
        });
    }
}