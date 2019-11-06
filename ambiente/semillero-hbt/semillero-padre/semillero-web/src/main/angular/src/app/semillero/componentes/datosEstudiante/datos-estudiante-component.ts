import { Component, OnInit } from '@angular/core';

/**
 * @description  Componente datos estudiante, el cual contiene 
 * los datos del estudiante del semillero
 * 
 * @author Fancisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
 */
@Component({
    selector: 'datos-estudiante',
    templateUrl: './datos-estudiante-component.html',
    styleUrls: ['./datos-estudiante-component.css']
})


export class DatosEstudianteComponent implements OnInit {

    /**
     * Atributo que determina los datos del estudiante del semillero
     */
    public datosEstudiante: string;

    /**
     * Constructor del componente
     */
    constructor() {
        
    }

    ngOnInit() {
        this.datosEstudiante = 'Francisco Alejandro Hoyos Rojas - Armenia'
    }
}