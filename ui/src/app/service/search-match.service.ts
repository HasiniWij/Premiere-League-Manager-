import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Match} from "../model/Match";

@Injectable({
  providedIn: 'root'
})
export class SearchMatchService {

  private serviceUrl = 'http://localhost:9000/api/matches';

  constructor(private http: HttpClient) { }


  getMatch(date :string): Observable<Match[]> {
    return this.http.get<Match[]>(this.serviceUrl+date);
  }

}

