import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShellComponent } from './shell.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ShellRoutingModule } from './shell-routing.module';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    // Altri moduli
  ],
  // Altri metadati del modulo
})
export class AppModule { }

@NgModule({ 
    declarations: [
        HeaderComponent, 
        ShellComponent,
        FooterComponent
        
    ],
    imports: [ 
    BrowserAnimationsModule,
    RouterModule, 
    ShellRoutingModule,
    CommonModule,
    MatIconModule,
    NgbModule,
    FormsModule
    ],
    exports: [
        ShellComponent
      ]
 
})
export class ShellModule {}
