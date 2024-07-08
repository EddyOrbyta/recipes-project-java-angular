import { Component } from '@angular/core';
import { AuthenticationService } from '../../@shared/http/user-guard/authentication.service';
import { AuthService } from '../auth-service/auth.service';
import { AuthenticationRequest } from '../auth-service/AuthenticationRequest';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {

  constructor(private router:Router, private registrationService: AuthService,  private authService: AuthenticationService){}
  authenticationForm: AuthenticationRequest={ 
    username: '',
    password: ''
  }

  toggleLogin(){
    this.router.navigate(['authorization/login']);
  }


  onSubmit(): void {
    this.registrationService.signup(this.authenticationForm).subscribe({
      next: (response) => {
        console.log('Risposta dalla chiamata API:', response);
        localStorage.setItem('userSession', JSON.stringify({ token:  response.token, username: response.username, role: response.role}));
        this.authService.updateAuthenticationStatus(true);
          
        

          this.router.navigate(['authorization/login']);
      },
      error: (error) => {
        alert(error.message)
        console.error('Errore durante la registrazione:', error, " messaggio: " , error);
      }
    });
  }


}
