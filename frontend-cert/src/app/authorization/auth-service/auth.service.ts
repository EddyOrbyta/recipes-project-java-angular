import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environments } from '../../../environments/environment';
import { AuthenticationRequest } from './AuthenticationRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiServerUrl = environments.apiBaseUrl;
  

  constructor(private http: HttpClient) { }
  public login(loginForm: AuthenticationRequest): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/auth/login`, loginForm).pipe(
      catchError(error => {
        // Gestisci eventuali errori qui
        console.log(error.message);
        throw 'Errore durante il login: ' + error.message;
      })
    );
  }



  public signup(registrationForm: AuthenticationRequest): Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/auth/signup`, registrationForm).pipe(
      catchError(error => {
        console.log(error.message);
        throw 'Errore durante la registrazione : ' + error.message;
      })
    );
  }

}
