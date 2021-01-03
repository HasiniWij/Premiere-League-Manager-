import { Component, OnInit } from '@angular/core';
import {DataSource} from '@angular/cdk/collections';
import {Observable} from "rxjs";
import {Club} from "../model/Club";
import {TableService} from "../service/table.service";


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  dataSource = new UserDataSource(this.tableService, "point");

  win(){    this.dataSource = new UserDataSource(this.tableService, "win"); }
  goal(){   this.dataSource = new UserDataSource(this.tableService, "goal"); }
  point(){  this.dataSource = new UserDataSource(this.tableService, "point");}

  displayedColumns = ['position', 'name', 'numOfWins', 'numOfDraws','numOfDefeats','goalDifference', 'numGoalsFor', 'numGoalsAgainst', 'numOfPoints','numOfMatchesPlayed'];

  constructor(private tableService: TableService) { }

  ngOnInit() { }

}

export class UserDataSource extends DataSource<any> {
  private readonly _sortBy: string;

  constructor(private tableService: TableService,sortBy: string) {
    super();
    this._sortBy = sortBy;
  }

  connect(): Observable<Club[]> {
    let data;
    if (this._sortBy == "win"){data=this.tableService.getByWin();}
    else if (this._sortBy == "goal"){data=this.tableService.getByGoal();}
    else {data = this.tableService.getClub();}
    return data
  }
  disconnect() {}
}
