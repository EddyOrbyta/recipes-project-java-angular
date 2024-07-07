import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {  HttpClientModule , HTTP_INTERCEPTORS} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminGuard } from './@shared/http/user-guard/admin-guard';
import { FanGuard } from './@shared/http/user-guard/fan-guard';
import { UserService } from './@shared/http/user-guard/user-utils.service';
import { JwtInterceptorService } from './@shared/http/interceptor/jwt-interceptor.service';
import { FormsModule } from '@angular/forms';
import { LandingPageModule } from './landing-page/landing-page.module';
import { ShellModule } from './shell/shell.module';
import { RouterModule } from '@angular/router';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ShopModule } from './shop/shop.module';
import { RistoranteModule } from './ristorante/ristorante.module';
import { SocialModule } from './social/social.module';
import { RicetteModule } from './ricette/ricette.module';
@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ShellModule,
    RouterModule,
    LandingPageModule,
    RistoranteModule,
    RicetteModule,
    SocialModule,
    ShopModule,
    NgbModule,
  ],
  providers: [
    AdminGuard, 
    FanGuard,
    UserService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptorService,
      multi: true
    }, 
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
