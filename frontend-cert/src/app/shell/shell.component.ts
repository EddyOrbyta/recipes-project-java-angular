// shell.component.ts
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../@shared/http/user-guard/authentication.service';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { Role } from '../@shared/http/user-guard/role-enum';
import { UserService } from '../@shared/http/user-guard/user-utils.service';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
   styleUrl: './shell.component.css'
})
export class ShellComponent { //implements OnInit {
  /*
  constructor(private authService: AuthenticationService, private router: Router, private userService: UserService) {}
  showWelcomeUser: boolean = false; 
  
  
  ngOnInit() {
    this.authService.isAuthenticated$.subscribe((isAuthenticated) => {
      this.showWelcomeUser = isAuthenticated;
    });

    this.updateWelcomeUserStatus();
    

    // Osserva i cambiamenti nel localStorage per aggiornare showWelcomeUser
    Observable.create((observer: any) => {
      const handler = () => {
        this.updateWelcomeUserStatus();
      };
      window.addEventListener('storage', handler);

      return () => window.removeEventListener('storage', handler);
    }).subscribe();
  }





  /*updateWelcomeUserStatus() {
    const userSession = localStorage.getItem('userSession');
    this.showWelcomeUser = !!userSession;

    if (userSession) {
      const user = JSON.parse(userSession);
      if (user.role === Role.Admin) {
        this.router.navigate(['admin']);
      } else if (user.role === Role.Fan) {
        this.router.navigate(['fan']);
      }
    } else {
      this.router.navigate(['']);
    }
  }*/
}