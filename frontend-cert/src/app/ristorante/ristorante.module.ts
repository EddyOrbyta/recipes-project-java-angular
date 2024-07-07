import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppComponent } from '../app.component';
import { FormsModule } from '@angular/forms';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { NgbCarousel, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RistoranteSectionComponent } from './ristorante-section/ristorante.component';
import { RistoranteRoutingModule } from './ristorante-routing.module';
import { RistoranteComponent } from './ristorante.component';



@NgModule({
  declarations: [
    RistoranteComponent,
    RistoranteSectionComponent
  ],
  imports: [
    NgbModule,
    CommonModule,
    RistoranteRoutingModule,
    FormsModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule, 
    MatInputModule,
    NgbCarousel
  ]
  ,
  bootstrap: [AppComponent]
})
export class RistoranteModule { }
