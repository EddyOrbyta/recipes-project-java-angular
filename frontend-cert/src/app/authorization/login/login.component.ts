import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { AuthenticationRequest } from '../auth-service/AuthenticationRequest';
import { AuthService } from '../auth-service/auth.service';
import { AuthenticationService } from '../../@shared/http/user-guard/authentication.service';

@Component({
  selector: 'app-auth-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {

  constructor(private router:Router, private registrationService: AuthService,  private authService: AuthenticationService){}
  authenticationForm: AuthenticationRequest={ 
    username: '',
    password: ''
  }

  toggleSignup(){
    this.router.navigate(['authorization/signup']);
  }


  onSubmit(): void {
    this.registrationService.login(this.authenticationForm).subscribe({
      next: (response) => {
        console.log('Risposta dalla chiamata API:', response);
        localStorage.setItem('userSession', JSON.stringify({ token:  response.token, username: response.username, role: response.role}));
        
        this.authService.updateAuthenticationStatus(true); 
        this.router.navigate(['ricette']);
 
      },
      error: (error) => {
        alert(error.message)
        console.error('Errore durante la registrazione:', error, " messaggio: " , error);
      }
    });
  }


}
