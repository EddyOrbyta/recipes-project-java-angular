import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environments } from '../../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private apiServerUrl = environments.apiBaseUrl;

  constructor(private http: HttpClient) { }
  

  public searchQuery(searchQuery: string): Observable<string> {
    const params = new HttpParams()
      .set('text', searchQuery.toString());
  
    return this.http.get<any>(`${this.apiServerUrl}/api/search/try`, { params });
  }
  


}
