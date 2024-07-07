import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private userData: any;

  constructor() {
    this.loadUserDataFromLocalStorage();
  }

  private loadUserDataFromLocalStorage(): void {
    const userSessionString = localStorage.getItem('userSession');
    if (userSessionString) {
      this.userData = JSON.parse(userSessionString);
    }
  }

  getEmail(): string {
    return this.userData?.email || '';
  }

  getRole(): string{
    return this.userData?.role || '';
  }
  getName(): string {
    return this.userData?.name || '';
  }

  getSurname(): string {
    return this.userData?.surname || '';
  }

  getToken(): string {
    return this.userData?.token || '';
  }
}