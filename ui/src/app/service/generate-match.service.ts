import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class GenerateMatchService {
   private serviceUrl: string ="http://localhost:9000/api/generateMatch";


  constructor(private http: HttpClient) { }

  public getMessage() {
    return this.http.get(this.serviceUrl).pipe(
      map(response => response)
    );
  }
}
