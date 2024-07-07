import { Component, OnInit } from '@angular/core';
import { RicettaService } from '../../@shared/http/service/ricetta/ricetta.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Ricetta } from '../../@shared/http/service/ricetta/Ricetta';
import { RicettaList } from '../../@shared/http/service/ricetta/RicettaList';

@Component({
  selector: 'app-third-section',
  templateUrl: './third-section.component.html',
  styleUrls: ['./third-section.component.css'],
})
export class ThirdSectionComponent implements OnInit {

  public ricette: Ricetta[] = [];
  public currentPage: number = 0;
  public totalPages: number = 0;
  public totalElements: number = 0;
  public pageSize: number = 20; 
  public totalPagesArray: number[] = [];

  constructor(private ricettaService: RicettaService) {}

  ngOnInit(): void {
    this.getEasyRicette(this.currentPage);
  }

  getEasyRicette(page: number): void {
    this.ricettaService.getEasyRicette(page, this.pageSize).subscribe(
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



  public viewRecipeDetails(ricetta: Ricetta){}
}
