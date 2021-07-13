import { Component, OnInit } from '@angular/core';
import { OxygenService } from '../service/oxygen.service';
import { PatientService } from '../service/patient.service';
import { SleepService } from '../service/sleep.service';
import { StepsService } from '../service/steps.service';

@Component({
  selector: 'app-doctor',
  templateUrl: './doctor.component.html',
  styleUrls: ['./doctor.component.css']
})
export class DoctorComponent implements OnInit {

  constructor(private patientService: PatientService,
    private oxygenService: OxygenService,
    private sleepService: SleepService,
    private stepsService: StepsService) {
  }

  public patientId = [];
  public oxygenSaturation = [];
  public stage = [];
  public startTime = [];
  public steps = [];

  ngOnInit(): void {
    this.grabAllData();
  }

  grabAllData() {
    this.patientService
      .getData()
      .subscribe((data) => { (this.patientId = data); console.log('Evo ih: ', data); });

    this.oxygenService
      .getData()
      .subscribe((oxy) => { (this.oxygenSaturation = oxy); console.log('Evo ih: ', oxy); });

    this.sleepService
      .getData()
      .subscribe((stag) => { (this.stage = stag, this.startTime = stag); console.log('Evo ih: ', stag); });

    this.stepsService
      .getData()
      .subscribe((step) => { (this.steps = step, this.startTime = step); console.log('Evo ih: ', step); });
  }

}
