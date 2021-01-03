import { NgModule } from '@angular/core';
import {MatButtonModule} from  '@angular/material/button';
import {MatTableModule} from  '@angular/material/table';
import { MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {MatFormField, MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";

const materiaComponents=[
   MatButtonModule,
   MatTableModule,
   MatDatepickerModule,
   MatNativeDateModule,
  MatFormFieldModule,
  MatInputModule
  ]

@NgModule({
  exports: [materiaComponents],

  imports: [materiaComponents]
})
export class MaterialModule { }
