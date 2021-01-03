import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DisplayMatchesComponent } from './display-matches/display-matches.component';
import { GenerateMatchComponent } from './generate-match/generate-match.component';
import { MatchByDateComponent } from './match-by-date/match-by-date.component';
import { TableComponent } from './table/table.component';
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
   {path:'table', component: TableComponent },
   {path:'display-matches', component:DisplayMatchesComponent},
   {path:"match-by-date",component:MatchByDateComponent},
   {path:"generate-match",component:GenerateMatchComponent},
   {path:"",component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [
  TableComponent,
  DisplayMatchesComponent,
  MatchByDateComponent,
  GenerateMatchComponent,
  HomeComponent
]
