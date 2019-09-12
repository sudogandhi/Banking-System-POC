import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {TransactionServiceService} from '../transaction-service.service';
import {Transaction} from '../transaction';

export interface AccountType {
  value: string;
  viewValue:  string;
}

@Component({
  selector: 'app-generate-statement',
  templateUrl: './generate-statement.component.html',
  styleUrls: ['./generate-statement.component.css'],
  providers:[DatePipe]
})


export class GenerateStatementComponent implements OnInit {
  statementForm=new FormGroup({
    accountControl: new FormControl('', [Validators.required]),
    periodControl: new FormControl('', [Validators.required]),
    mon: new FormControl('',[Validators.required]),
  toDate:new FormControl('', [Validators.required]),
  fromDate:new FormControl('', [Validators.required,])
});
  accountType: AccountType[];
  months: string[];
  trans: Transaction[];
  p: number =1;



  constructor(private _service: TransactionServiceService) {
  }

  ngOnInit() {
    this.accountType = [
      {value: 'salary', viewValue:'Salary'},
      {value: 'savings', viewValue:'Savings'},
      {value: 'salary', viewValue:'Current'},
    ];

    this.months = ['January','February','March','April','May',
      'June','July','August','September','October','November','December'];
  }

  onFormSubmit()
  {
      console.log(this.statementForm.get('fromDate').value);
      this._service.getTransaction().subscribe(data=>this.trans = data);
      //console.log("rachana");
  }
}
