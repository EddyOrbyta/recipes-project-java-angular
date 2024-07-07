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
import { RicetteComponent } from './ricette.component';
import { RicetteRoutingModule } from './ricette-routing.module';
import { FirstSectionComponent } from './first-section/first-section.component';
import { SecondSectionComponent } from './second-section/second-section.component';
import { ThirdSectionComponent } from './third-section/third-section.component';
import { FilterSectionComponent } from './filter-section/filter-section.component';



@NgModule({
  declarations: [
    RicetteComponent,
    FirstSectionComponent,
    SecondSectionComponent,
    ThirdSectionComponent,
    FilterSectionComponent
  ],
  imports: [
    NgbModule,
    RicetteRoutingModule,
    CommonModule,
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
export class RicetteModule { }
