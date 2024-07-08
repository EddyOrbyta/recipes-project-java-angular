// shell.component.ts
import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../@shared/http/user-guard/authentication.service';
import { Router } from '@angular/router';
import { UserService } from '../@shared/http/user-guard/user-utils.service';
import { LoginDialogComponent } from './login-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-shell',
  templateUrl: './shell.component.html',
   styleUrl: './shell.component.css'
})
export class ShellComponent implements OnInit {

  constructor(private authService: AuthenticationService, private router: Router, private userService: UserService, private dialog: MatDialog) {}
  allowNavigation: boolean = false; 
  

  ngOnInit() {
    this.authService.isAuthenticatedSubject.subscribe((isAuthenticated) => {
      this.allowNavigation = isAuthenticated;
    });
  }

  openLoginDialog(): void {
    this.dialog.open(LoginDialogComponent, {
      width: '400px',
    });
  }
}