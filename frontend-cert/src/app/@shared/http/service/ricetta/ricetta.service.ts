import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RicettaList } from './RicettaList';
import { environments } from '../../../../../environments/environment';
import { RicettaListWithScore } from './RicettaListWithScore';
@Injectable({
  providedIn: 'root'
})
export class RicettaService {
  private apiServerUrl = environments.apiBaseUrl;

  constructor(private http: HttpClient) { }
  

  public getRicette(page: number, size: number): Observable<RicettaList> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());
  
    return this.http.get<RicettaList>(`${this.apiServerUrl}/api/ricetta/all`, { params });
  }
  public getBestRicette(page: number, size: number): Observable<RicettaListWithScore> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());
  
    return this.http.get<RicettaListWithScore>(`${this.apiServerUrl}/api/ricetta/5star`, { params });
  }

  public getEasyRicette(page: number, size: number): Observable<RicettaList> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString());
  
    return this.http.get<RicettaList>(`${this.apiServerUrl}/api/ricetta/easy`, { params });
  }
  public getRicetteBasedOnFilter(page: number, size: number, filters: Array<any>): Observable<RicettaListWithScore> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString())
      .set('filters', filters.toString());
  
    return this.http.get<RicettaListWithScore>(`${this.apiServerUrl}/api/ricetta/filter`, { params });
  }

}
