import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatCommonModule } from '@angular/material/core';

import { ShellRoutingModule } from './shell-routing.module';
import { ShellComponent } from './shell.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginDialogComponent } from './login-dialog.component';

@NgModule({
  declarations: [
    HeaderComponent,
    ShellComponent,
    FooterComponent,
    LoginDialogComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    ShellRoutingModule,
    NgbModule,
    MatIconModule,
    FormsModule,
    MatDialogModule,
    MatInputModule,
    MatButtonModule,
    MatCommonModule
  ],
  exports: [
    ShellComponent
  ],
})
export class ShellModule { }
