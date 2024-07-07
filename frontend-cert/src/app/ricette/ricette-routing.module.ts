import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RicetteComponent } from './ricette.component';
const routes: Routes = [
  
    {path: '', component: RicetteComponent}
 ];
 
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class  RicetteRoutingModule { 
  
}
