import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ShopComponent } from './shop.component';
import { ShopRoutingModule } from './shop-routing.module';
import { AppComponent } from '../app.component';
import { FormsModule } from '@angular/forms';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { NgbCarousel, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BookComponent } from './book/book.component';



@NgModule({
  declarations: [
    ShopComponent,
    BookComponent
  ],
  imports: [
    NgbModule,
    CommonModule,
    ShopRoutingModule,
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
export class ShopModule { }
