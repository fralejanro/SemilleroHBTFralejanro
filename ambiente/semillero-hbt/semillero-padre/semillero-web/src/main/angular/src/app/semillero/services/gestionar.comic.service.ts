import { Injectable } from '@angular/core';
import { Injector } from "@angular/core";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from './template.service';
import { HttpClient, HttpHeaders,HttpParams } from '@angular/common/http';
import { ComicDTO } from '../dto/comic.dto';

/**
 * Servicio encargado de llamar a los servicios REST de
 * ejemplo
 */
@Injectable({
  providedIn: 'root'
})
export class GestionarComicService extends AbstractService {

  /**
   * Constructor
   */
  constructor(injector: Injector, private httpClient: HttpClient) {
    super(injector);
  }


  public consultarComics(): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics');
  }

  public consultarComic(idComic: number): Observable<any> {
    return this.httpClient.get('http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=' + idComic.toString());
  }

  public crearComic(comicDTO: ComicDTO): Observable<any> {
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/crear', comicDTO);
  }


  public eliminarComic(idComic: number): Observable<any> {
    const options = {params: new HttpParams({fromString: 'idComic=' + idComic.toString()})};
    return this.httpClient.post('http://localhost:8085/semillero-servicios/rest/GestionarComic/eliminar',{}, options);
  }
}
