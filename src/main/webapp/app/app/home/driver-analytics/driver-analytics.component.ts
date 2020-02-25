import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import { Chart } from 'chart.js';
import {DriverService} from "../../driver/driver.service";

@Component({
  selector: 'app-driver-analytics',
  templateUrl: './driver-analytics.component.html',
  styleUrls: ['./driver-analytics.component.css']
})
export class DriverAnalyticsComponent implements OnInit {
  @ViewChild('chartCanvas', {static: true}) chartCanvas: ElementRef;
  myChart: Chart;

  constructor(private driverService: DriverService) { }

  ngOnInit(): void {
    this.getDriversRoutes();
    // this.initChart();
  }

  getDriversRoutes() {
    this.driverService.getDriversTotalRoutes().subscribe(data => {
      this.initChart(data);
    });
  }

  initChart(d: {fullName: string, totalRoutes: number}[]) {
    const labels: string[] = [];
    const data: number[] = [];
    for (let l of d) {
      labels.push(l.fullName);
      data.push(l.totalRoutes);
    }

    this.myChart = new Chart(this.chartCanvas.nativeElement, {
      type: 'bar',
      data: {
        labels, // : ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
          label: '# of Votes',
          data, // : [12, 19, 3, 5, 2, 3],
          backgroundColor: [
            'rgba(255, 99, 132, 0.2)',
            'rgba(54, 162, 235, 0.2)',
            'rgba(255, 206, 86, 0.2)',
            'rgba(75, 192, 192, 0.2)',
            'rgba(153, 102, 255, 0.2)',
            'rgba(255, 159, 64, 0.2)'
          ],
          borderColor: [
            'rgba(255, 99, 132, 1)',
            'rgba(54, 162, 235, 1)',
            'rgba(255, 206, 86, 1)',
            'rgba(75, 192, 192, 1)',
            'rgba(153, 102, 255, 1)',
            'rgba(255, 159, 64, 1)'
          ],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });
  }

}
