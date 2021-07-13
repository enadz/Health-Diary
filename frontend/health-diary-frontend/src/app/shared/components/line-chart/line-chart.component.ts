import { Component, OnInit } from '@angular/core';
import { ChartDataSets, ChartOptions } from 'chart.js';
import { Color, Label } from 'ng2-charts';


@Component({
  selector: 'app-line-chart',
  templateUrl: './line-chart.component.html',
  styleUrls: ['./line-chart.component.css']
})
export class LineChartComponent implements OnInit {
  public lineChartData: ChartDataSets[] = [
    { data: [71.7, 69.12, 73.5, 77, 65, 72.81, 73.22], label: 'Average Daily Heart Rate' },
    { data: [98, 98, 97, 97, 98, 97, 97], label: 'Average Daily Oxygen Saturation' },
    { data: [70.36, 54.22, 100.17, 24, 98.83, 81.77, 121.44], label: 'Daily Steps expressed in Hundereds' },
  ];
  public lineChartLabels: Label[] = ['June 1', 'June 2', 'June 3', 'June 4', 'June 5', 'June 6', 'June 7'];
  public lineChartOptions: (ChartOptions & { annotation?: any }) = {
    responsive: true,
  };
  public lineChartColors: Color[] = [
    {
      borderColor: 'black',
      backgroundColor: 'rgba(255,0,0,0.3)',
    },
  ];
  public lineChartLegend = true;
  public lineChartType = 'line';
  public lineChartPlugins = [];

  constructor() { }

  ngOnInit() {
  }

}
