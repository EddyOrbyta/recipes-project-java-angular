import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from "@angular/router";
import { UserService } from "./user-utils.service";
import {Role} from "./role-enum";

@Injectable({
    providedIn: 'root'
  })
  export class AdminGuard implements CanActivate {
    constructor(private userService: UserService, private router: Router) {}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot
    ): boolean {
      console.info('CanActivate called');
      const role: string = this.userService.getRole();
      if (role == Role.Admin) {
        return true;
      } else {
        //this.router.navigate(['']);
        return true;
      }
    }
  }
  