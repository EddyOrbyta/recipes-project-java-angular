import { Component, OnInit } from '@angular/core';
import { UserService } from '../../@shared/http/user-guard/user-utils.service';
import { Router } from '@angular/router';
import { Role } from '../../@shared/http/user-guard/role-enum';
import { SearchService } from '../../@shared/http/search.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userRole: string = '';
  searchQuery: string = '';
  isCollapsed = true;
  isSearchVisible = true;
  role: string = '';

  constructor(private userService: UserService, private router: Router, private searchService:SearchService) {
    this.userRole = userService.getRole();
  }

  ngOnInit(): void {
    this.role = this.userService.getRole();
  }

  public navigateHome() {
      this.router.navigate(['']);
  }

  public navigateAllRicetta() {
    this.router.navigate(['ricette']);
  }

  public navigateAddRicetta() {
    this.router.navigate(['ricetta/add']);
  }

  public navigateAddIngrediente() {
    this.router.navigate(['ingrediente/add']);
  }

  public navigateRistorante() {
    this.router.navigate(['ristorante']);
  }

  public navigateSocial() {
    this.router.navigate(['social']);
  }
  
  public navigateShop() {
    this.router.navigate(['shop']);
  }
  public isAdmin(): boolean {
    return this.role === Role.Admin;
  }

  public isFan(): boolean {
    return this.role === Role.Fan;
  }
  public accedi(){
    this.router.navigate(['login']);
  }

  public onSearch() {
    console.log('Search query:', this.searchQuery);
    this.searchService.searchQuery(this.searchQuery).subscribe(
      (data: any) => {
        //restiure lista di ricette? in base a cosa al nome? 
        console.log(data);
      },
      (error: HttpErrorResponse) => {
        //mat dialog con "ci dispiace non è stato trovato nulla che soddisfi la richiesta?"
        console.log(error.message);
      }
      
    )
  }
}
