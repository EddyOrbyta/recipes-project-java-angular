import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ShellComponent } from './shell.component';
import { FanGuard } from '../@shared/http/user-guard/fan-guard';
import { AdminGuard } from '../@shared/http/user-guard/admin-guard';
import { UserGuard } from '../@shared/http/user-guard/user-guard';
const routes: Routes = [
  {
    path: '',
    component: ShellComponent,
    children: [
      {
        path: '',
        loadChildren: () => import('../landing-page/landing-page.module').then(m => m.LandingPageModule)
      }, 
      {
        path: 'ricette',
        loadChildren: () => import('../ricette/ricette.module').then(m => m.RicetteModule) , canActivate: [UserGuard]
      },
      {
        path: 'shop',
        loadChildren: () => import('../shop/shop.module').then(m => m.ShopModule)
      },
      {
        path: 'social',
        loadChildren: () => import('../social/social.module').then(m => m.SocialModule)
      },
      {
        path: 'ristorante',
        loadChildren: () => import('../ristorante/ristorante.module').then(m => m.RistoranteModule)
      },
      {
        path: 'authorization',
        loadChildren: () => import('../authorization/auth.module').then(m => m.AuthorizationModule)
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShellRoutingModule {}
