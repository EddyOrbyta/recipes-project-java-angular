import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from '../app.component';
import { FormsModule } from '@angular/forms';
import {MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { NgbCarousel, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AuthorizationRoutingModule } from './auth-routing.module';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { AuthorizationComponent } from './auth.component';



@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent,
    AuthorizationComponent
  ],
  imports: [
    NgbModule,
    CommonModule,
    AuthorizationRoutingModule,
    FormsModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule, 
    MatInputModule,
    NgbCarousel
  ]
  ,
  bootstrap: [AppComponent]
})
export class AuthorizationModule { }
