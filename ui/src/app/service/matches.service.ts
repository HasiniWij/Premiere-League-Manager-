import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Match} from '../model/Match';
import {Observable} from 'rxjs';


@Injectable()
export class MatchesService {
  private serviceUrl = 'http://localhost:9000/api/viewMatch';

  constructor(private http: HttpClient) { }

  getMatch(): Observable<Match[]> {
    return this.http.get<Match[]>(this.serviceUrl);
  }

}
