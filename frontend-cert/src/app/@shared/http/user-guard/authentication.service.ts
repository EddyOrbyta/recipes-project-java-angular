import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  
  public isAuthenticatedSubject = new BehaviorSubject<boolean>(false);

  constructor() {
    this.loadInitialAuthenticationStatus();
  }

  private loadInitialAuthenticationStatus(): void {
    const userSession = localStorage.getItem('userSession');
    this.isAuthenticatedSubject.next(!!userSession);
  }

  updateAuthenticationStatus(isAuthenticated: boolean) {
    this.isAuthenticatedSubject.next(isAuthenticated);
  }
}
