import { Component, OnInit } from '@angular/core';
import {DataSource} from '@angular/cdk/collections';
import {Match} from "../model/Match";
import {Observable} from "rxjs";
import {MatchesService} from "../service/matches.service";

@Component({
  selector: 'app-display-matches',
  templateUrl: './display-matches.component.html',
  styleUrls: ['./display-matches.component.css']
})
export class DisplayMatchesComponent implements OnInit {

  dataSource = new UserDataSource(this.matchService);
  displayedColumns = ['date', 'clubA', 'clubAGoal', 'clubB', "clubBGoal"];

  constructor(private matchService: MatchesService) { }

  ngOnInit() { }
}

export class UserDataSource extends DataSource<any> {

  constructor(private matchService: MatchesService) {
    super();
  }

  connect(): Observable<Match[]> {
    return this.matchService.getMatch();
  }

  disconnect() {}
}
