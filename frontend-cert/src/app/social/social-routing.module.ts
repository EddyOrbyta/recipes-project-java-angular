import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SocialComponent } from './social.component';
const routes: Routes = [
  
    {path: '', component: SocialComponent}
 ];
 
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [],
})
export class  SocialRoutingModule { 
  
}
