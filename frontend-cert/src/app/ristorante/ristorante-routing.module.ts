import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RistoranteComponent } from './ristorante.component';
const routes: Routes = [
  
    {path: '', component: RistoranteComponent}
 ];
 
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class  RistoranteRoutingModule { 
  
}
