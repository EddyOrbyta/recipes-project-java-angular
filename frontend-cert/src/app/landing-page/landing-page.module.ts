import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LandingPageComponent } from './landing-page.component';
import { LandingPageRoutingModule } from './landing-page-routing.module';
import { AppComponent } from '../app.component';
import { FormsModule } from '@angular/forms';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { HomeComponent } from './home/home.component';
import { VideoGalleryComponent } from './video-gallery/video-gallery.component';
import { NgbCarousel, NgbModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [
    LandingPageComponent,
    HomeComponent,
    VideoGalleryComponent
  ],
  imports: [
    NgbModule,
    CommonModule,
    LandingPageRoutingModule,
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
export class LandingPageModule { }
