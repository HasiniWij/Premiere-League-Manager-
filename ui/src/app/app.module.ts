import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TableComponent } from './table/table.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule} from './material/material.module';
import { DisplayMatchesComponent } from './display-matches/display-matches.component';
import { MatchByDateComponent } from './match-by-date/match-by-date.component';
import { GenerateMatchComponent } from './generate-match/generate-match.component'

import {HttpClientModule} from '@angular/common/http'
import {TableService} from "./service/table.service";
import {MatchesService} from "./service/matches.service";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {SearchMatchService} from "./service/search-match.service";
import {ReactiveFormsModule} from "@angular/forms";
import {GenerateMatchService} from "./service/generate-match.service";
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    TableComponent,
    DisplayMatchesComponent,
    MatchByDateComponent,
    GenerateMatchComponent,
    HomeComponent,
  ],
  imports: [

    BrowserModule,
    AppRoutingModule,
    NoopAnimationsModule,
    MaterialModule,
    HttpClientModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  providers: [TableService,MatchesService,SearchMatchService,GenerateMatchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
