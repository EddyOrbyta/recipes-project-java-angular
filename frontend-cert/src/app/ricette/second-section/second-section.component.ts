import { Component, OnInit } from '@angular/core';
import { RicettaService } from '../../@shared/http/service/ricetta/ricetta.service';
import { HttpErrorResponse } from '@angular/common/http';
import { RicettaListWithScore } from '../../@shared/http/service/ricetta/RicettaListWithScore';
import { RicettaWithScore } from '../../@shared/http/service/ricetta/RicettaWithScore';

@Component({
  selector: 'app-second-section',
  templateUrl: './second-section.component.html',
  styleUrls: ['./second-section.component.css'],
})
export class SecondSectionComponent implements OnInit {
  public ricette: RicettaWithScore[] = [];
  public currentPage: number = 0;
  public totalPages: number = 0;
  public totalElements: number = 0;
  public pageSize: number = 20; 
  public totalPagesArray: number[] = [];

  constructor(private ricettaService: RicettaService) {}

  ngOnInit(): void {
    this.getBestRicette(this.currentPage);
  }

  getBestRicette(page: number): void {
    this.ricettaService.getBestRicette(page, this.pageSize).subscribe(
      (data: RicettaListWithScore) => {
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

  getStarsArray(score: number): number[] {
    const fullStars = Math.floor(score);
    return Array(fullStars).fill(0);
  }

  getEmptyStarsArray(score: number): number[] {
    const fullStars = Math.floor(score);
    const emptyStars = 5 - fullStars;
    return Array(emptyStars).fill(0);
  }
}
