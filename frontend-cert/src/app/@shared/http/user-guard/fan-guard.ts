import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { UserService } from "./user-utils.service";
import {Role} from "./role-enum";
import { LoginDialogComponent } from "../../../shell/login-dialog.component";
import { MatDialog } from "@angular/material/dialog";
@Injectable({
    providedIn: 'root'
  })
  export class FanGuard implements CanActivate {
    constructor(private userService: UserService, private router: Router, private dialog: MatDialog) {}

    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot
    ): boolean {
      console.info('CanActivate called');
      const role: string = this.userService.getRole();
      if (role == Role.Fan) {
        return true;
      } else {
        this.openLoginDialog();
        return false;
      }
    }

    openLoginDialog(): void {
      this.dialog.open(LoginDialogComponent, {
        width: '400px',
      });
    }

  }

  