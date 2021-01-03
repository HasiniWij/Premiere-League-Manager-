import { Component, OnInit } from '@angular/core';
import {SearchMatchService} from '../service/search-match.service';
import {Observable} from "rxjs";
import {DataSource} from "@angular/cdk/collections";
import {Match} from "../model/Match";

@Component({
  selector: 'app-match-by-date',
  templateUrl: './match-by-date.component.html',
  styleUrls: ['./match-by-date.component.css']
})

export class MatchByDateComponent implements OnInit {
  dataSource: any;
  regex1: RegExp=/^[+0-9]{2}$/
  regex2: RegExp=/^[+0-9]{4}$/
  message=''
  isSearched=false;

  validation(day :string, month:string, year:string){
    if (day.match(this.regex1) &&month.match(this.regex1)&&year.match(this.regex2)){


      if(parseFloat(day) <= 31 &&parseFloat(day) >= 1 && parseFloat(month) <=12 &&parseFloat(month) >= 1){
        this.message=''
        this.postData(day,month,year)
        this.isSearched=true
      }
      else{
        this.message="Please enter a valid date."
      }
    }
    else{
      this.message="Please enter a valid date in the format DD-MM-YYYY."
    }
  }


  postData(day :string, month:string, year:string) {
    this.dataSource = new UserDataSource(this.searchMatchService,year+"-"+month+"-"+day);
  }

  displayedColumns = ['clubA', 'clubAGoal', 'clubB', "clubBGoal"];


  constructor(private searchMatchService: SearchMatchService) { }

  ngOnInit(): void {}

}

export class UserDataSource extends DataSource<any> {

  constructor(private searchMatchService: SearchMatchService, private date:string) {
    super();
  }

  connect(): Observable<Match[]> {
    return this.searchMatchService.getMatch(this.date);
  }
  disconnect() {}
}
