import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { LineChartComponent } from './components/line-chart/line-chart.component';
import {ChartsModule} from 'ng2-charts';


@NgModule({
  declarations: [HeaderComponent, LineChartComponent],
  imports: [
    CommonModule,
    RouterModule,
    ChartsModule
  ],
  exports: [
    HeaderComponent,
    LineChartComponent
  ]
})
export class SharedModule { }
