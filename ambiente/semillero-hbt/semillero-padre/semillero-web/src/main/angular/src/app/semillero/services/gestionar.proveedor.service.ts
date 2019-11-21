import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service';
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { ProveedorDTO } from '../dto/Proveedor.dto';
import { PersonaDTO } from '../dto/Persona.dto';


/**
 * Servicio encargado de llamar a los servicios REST de
 * ejemplo
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarProveedorService extends AbstractService {

  /**
   * Constructor
   */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }


 

  public crearProveedor(proveedorDTO: ProveedorDTO): Observable<any> {
    return this.httpClient.post(' http://localhost:8085/semillero-servicios/rest/GestionarProveedor/crearProveedor',proveedorDTO);
  }

}
