import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent } from './semillero/componentes/gestionarComic/consultarComic/consultar-comic-component';
import { GestionarProveedorComponent } from './semillero/componentes/gestionarProveedor/gestionar-proveedor-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'consultar-comic', component: ConsultarComicComponent, data: null},
  { path: 'gestionar-proveedor', component: GestionarProveedorComponent, data: null}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
