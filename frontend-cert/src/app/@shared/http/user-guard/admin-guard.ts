import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { UserService } from "./user-utils.service";
import {Role} from "./role-enum";
import { MatDialog } from "@angular/material/dialog";
import { LoginDialogComponent } from "../../../shell/login-dialog.component";

@Injectable({
    providedIn: 'root'
  })
  export class AdminGuard implements CanActivate {
    constructor(private userService: UserService, private router: Router, private dialog: MatDialog) {}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot
    ): boolean {
      console.info('CanActivate called');
      const role: string = this.userService.getRole();
      console.log(role)
      if (role == Role.Admin) {
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

  