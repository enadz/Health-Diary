import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { LineChartComponent } from './components/line-chart/line-chart.component';



@NgModule({
  declarations: [HeaderComponent, LineChartComponent],
  imports: [
    CommonModule,
    RouterModule
  ],
  exports: [
    HeaderComponent,
    LineChartComponent
  ]
})
export class SharedModule { }
