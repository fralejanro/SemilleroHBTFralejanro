import {Component, OnInit} from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarProveedorService } from '../../../services/gestionar.proveedor.service';
import { PersonaDTO } from 'src/app/semillero/dto/persona.dto';
import { ProveedorDTO } from 'src/app/semillero/dto/proveedor.dto';

/**
 * @description Componenete gestionar proveedor
 * 
 * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
 */
@Component({
    selector: 'crear-proveedor',
    templateUrl: './crear-proveedor-component.html',
    styleUrls: ['./crear-proveedor-component.css']
})

export class CrearProveedorComponent implements OnInit{

    /**
     * Atributo que contiene los controles del formulario
     */
    public crearProveedorForm: FormGroup;

    /**
     * Atributo que representa una persona
     */
    public personaDTO: PersonaDTO;

    /**
     * Atributo que representa un proveedor
     */
    public proveedorDTO: ProveedorDTO;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted: boolean;
   
    /**
     * Constructor del componente
     * @param fb 
     */
    constructor(private fb: FormBuilder, 
        private router: Router,
        private gestionarProveedorService: GestionarProveedorService,){
        this.crearProveedorForm = this.fb.group({
            nombre: [null, Validators.required],
            numeroIdentificacion: [null, Validators.required],
            tipoVia: [null, Validators.required],
            numeroUno: [null, Validators.required],
            numeroDos: [null, Validators.required],
            informacionAdicional: [null],
            fechaCreacion: [null, Validators.required],
            estado: [null, Validators.required],
            montoCredito: [null, Validators.required],
        });

    }
    
    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    ngOnInit():void{
        
    }

     /**
     * @description Metodo encargado de crear un Proveedor
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    public crearProveedor(): void {
        this.submitted = true;
        if (this.crearProveedorForm.invalid) {
            return;
        }else{
        this.personaDTO = new PersonaDTO();
        this.personaDTO.nombre = this.crearProveedorForm.controls.nombre.value;
        this.personaDTO.numeroIdentificacion = this.crearProveedorForm.controls.numeroIdentificacion.value;
        this.proveedorDTO = new ProveedorDTO();
        this.proveedorDTO.direccion = this.construirDireccion();
        this.proveedorDTO.estado = this.crearProveedorForm.controls.estado.value;
        this.proveedorDTO.fechaCreacion= this.crearProveedorForm.controls.fechaCreacion.value;
        this.proveedorDTO.personaDTO = this.personaDTO;

        this.gestionarProveedorService.crearProveedor(this.proveedorDTO).subscribe(resultadoDTO => {
            if(resultadoDTO.exitoso) {
                
            }
                console.log(resultadoDTO.mensajeEjecucion);
            
        }, error => {
            console.log(error);
        });
    }
    }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    get f() {
        return this.crearProveedorForm.controls;
    }

    /**
     * @description Método encargado de construir la dirección de un proveedor
     * @author Francisco Alejandro Hoyos Rojas <fralejanro@gmail.com>
     */
    private construirDireccion(): string{
        let tipoVia = this.crearProveedorForm.controls.tipoVia.value;
        let numeroUno = this.crearProveedorForm.controls.numeroUno.value;
        let numeroDos = this.crearProveedorForm.controls.numeroDos.value;
        let informacionAdicional = this.crearProveedorForm.controls.informacionAdicional.value;
        return tipoVia + " " + numeroUno +" - "+ numeroDos +" "+ informacionAdicional;
    }
}