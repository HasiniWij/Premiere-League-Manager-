import { Component, OnInit } from '@angular/core';
import {GenerateMatchService} from "../service/generate-match.service";

@Component({
  selector: 'app-generate-match',
  templateUrl: './generate-match.component.html',
  styleUrls: ['./generate-match.component.css']
})
export class GenerateMatchComponent implements OnInit {

  message =""  ;

  constructor(private appService: GenerateMatchService) {
    this.appService.getMessage().subscribe((data: any) => {
      this.message = data;
    });
  }

  ngOnInit(): void {}
}
