import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { RicettaList } from '../../@shared/http/service/ricetta/RicettaList'; // Adjust the path as per your project structure
import { RicettaService } from '../../@shared/http/service/ricetta/ricetta.service';
import { Ricetta } from '../../@shared/http/service/ricetta/Ricetta';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public ricette: Ricetta[] = [];
  public currentPage: number = 0;
  public totalPages: number = 0;
  public totalElements: number = 0;
  public pageSize: number = 20; 
  public totalPagesArray: number[] = [];
  constructor(private ricettaService: RicettaService) {}

  ngOnInit(): void {
    this.getRicette(this.currentPage);
  }

  getRicette(page: number): void {
    this.ricettaService.getRicette(page, this.pageSize).subscribe(
      (data: RicettaList) => {
        this.ricette = data.ricettaList;
        this.totalPages = data.totalPages;
        this.currentPage = data.currentPage;
        this.totalElements = data.totalElements;
        
        // Aggiornamento dell'array di numeri di pagina
        this.totalPagesArray = Array.from({ length: this.totalPages }, (_, i) => i);
        
        console.log('Ricette ricevute:', this.ricette);
      },
      (error: HttpErrorResponse) => {
        console.error('Errore durante il recupero delle ricette:', error.message);
      }
    );
  }
  
  public handlePreviousClick(): void {
    if (this.currentPage > 0) {
      this.currentPage--;
      this.getRicette(this.currentPage);
    }
  }

  public handleNextClick(): void {
    if (this.currentPage < this.totalPages - 1) {
      this.currentPage++;
      this.getRicette(this.currentPage);
    }
  }

  public handlePageClick(page: number): void {
    if (page >= 0 && page < this.totalPages) {
      this.getRicette(page);
    }
  }

  public getDifficoltaColor(difficolta: string): string{
    if(difficolta === 'BASSA') 
      return "green";
    else if(difficolta === 'MEDIO') 
      return "orange";
    else if(difficolta === 'ALTA') 
      return "red";
    else return "black";
  }
  
  public getValueBasedOnDifficolta(difficolta: string): number{
    if(difficolta === 'BASSA') 
      return 25;
    else if(difficolta === 'MEDIO') 
      return 50;
    else if(difficolta === 'ALTA') 
      return 100;
    else return 100;
  }
 
  public viewRecipeDetails(ricetta: Ricetta) :void {
    //check if user has permission to do it (MUST BE A FAN)
  }
}
