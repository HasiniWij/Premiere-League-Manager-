import { Injectable }   from '@angular/core';
import { HttpClient }   from '@angular/common/http';
import {Club} from '../model/Club'
import {Observable} from "rxjs";


@Injectable()
export class TableService {
  private serviceUrl = 'http://localhost:9000/api/club';
  private serviceUrlForWin = 'http://localhost:9000/api/byWin';
  private serviceUrlForGoal = 'http://localhost:9000/api/byGoal'

  constructor(private http: HttpClient) { }

  getClub(): Observable<Club[]> {
    return this.http.get<Club[]>(this.serviceUrl);
  }
  getByWin(): Observable<Club[]> {
    return this.http.get<Club[]>(this.serviceUrlForWin);
  }
  getByGoal(): Observable<Club[]> {
    return this.http.get<Club[]>(this.serviceUrlForGoal);
  }
}
