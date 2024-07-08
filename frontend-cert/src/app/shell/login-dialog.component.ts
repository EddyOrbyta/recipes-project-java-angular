import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-login-dialog',
  template: `
    <h2 mat-dialog-title>Accedi</h2>
    <mat-dialog-content>
      <p>Per accedere a questa pagina, devi prima effettuare il login.</p>
    </mat-dialog-content>
    <mat-dialog-actions align="end">
      <button mat-button mat-dialog-close>Chiudi</button>
      <!-- Aggiungi un pulsante per reindirizzare all pagina di login -->
      <button mat-button routerLink="/authorization" mat-dialog-close>Accedi</button>
    </mat-dialog-actions>
  `,
})
export class LoginDialogComponent {
  constructor(public dialogRef: MatDialogRef<LoginDialogComponent>) {}
}
