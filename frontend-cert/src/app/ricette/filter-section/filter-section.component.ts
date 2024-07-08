import { Component, OnInit } from '@angular/core';
import { RicettaListWithScore } from '../../@shared/http/service/ricetta/RicettaListWithScore';
import { HttpErrorResponse } from '@angular/common/http';
import { RicettaService } from '../../@shared/http/service/ricetta/ricetta.service';
import { RicettaWithScore } from '../../@shared/http/service/ricetta/RicettaWithScore';

@Component({
  selector: 'app-filter-section',
  templateUrl: './filter-section.component.html',
  styleUrls: ['./filter-section.component.css'],
})
export class FilterSectionComponent implements OnInit {
  public ricette: RicettaWithScore[] = [];
  public currentPage: number = 0;
  public totalPages: number = 0;
  public totalElements: number = 0;
  public pageSize: number = 20;
  public totalPagesArray: number[] = [];

  public filters: any = {
    difficolta: '',
    tipo: '',
    visualizzazioni: null,
    categoria: '',
    rating: null,
    numPersone: null,
    tempoPreparazione: null
  };

  public difficoltaOptions: string[] = ['BASSA', 'MEDIA', 'ALTA'];
  public tipoOptions: string[] = ['ANTIPASTO', 'PRIMO', 'SECONDO', 'CONTORNO', 'DESSERT', 'BEVANDA', 'ALTRO'];
  public categoriaOptions: string[] = ['DOLCE', 'SALATO'];
  public ratingOptions: number[] = [1, 2, 3, 4, 5];
  public numPersoneOptions: number[] = [1, 2, 4, 6, 8];


  constructor(private ricettaService: RicettaService) {}

  ngOnInit(): void {
  }

  getRicetteBasedOnFilter(page: number, filters?: any): void {
    this.ricettaService.getRicetteBasedOnFilter(page, this.pageSize, filters).subscribe(
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
  onNumPersoneChange(event: Event, num: number) {
    const checked = (event.target as HTMLInputElement).checked;
    if (checked) {
      this.filters.numPersone.push(num);
    } else {
      this.filters.numPersone = this.filters.numPersone.filter((n: number) => n !== num);
    }
  }
  sendRequest(): void {}

  getStarsArray(score: number): number[] {
    const fullStars = Math.floor(score);
    return Array(fullStars).fill(0);
  }

  getEmptyStarsArray(score: number): number[] {
    const fullStars = Math.floor(score);
    const emptyStars = 5 - fullStars;
    return Array(emptyStars).fill(0);
  }

  onFilterSubmit(): void {
    this.getRicetteBasedOnFilter(this.currentPage, this.filters);
  }

  handlePreviousClick(): void {
    if (this.currentPage > 0) {
      this.getRicetteBasedOnFilter(this.currentPage - 1, this.filters);
    }
  }

  handleNextClick(): void {
    if (this.currentPage < this.totalPages - 1) {
      this.getRicetteBasedOnFilter(this.currentPage + 1, this.filters);
    }
  }

  handlePageClick(page: number): void {
    this.getRicetteBasedOnFilter(page, this.filters);
  }

  viewRecipeDetails(ricetta: any): void {
    // Implement your logic to view recipe details here
  }
}
  