import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DatePipe} from '@angular/common';
import {Transaction} from '../transaction';
import {GenerateStatementService} from './generate-statement.service';

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


export class GenerateStatementComponent implements OnInit
{
      statementForm=new FormGroup({
        accountControl: new FormControl('', [Validators.required]),
        periodControl: new FormControl('', [Validators.required]),
    });
  accountNumbers: AccountType[]=[];
  accounts: any=[];
  months: string[];
  trans: Transaction[];
  p: number =1;
  action: string='';


  constructor(private _service: GenerateStatementService) {
  }

  ngOnInit() {
          this._service.getAccountNumbers().subscribe(data=>{
            this.accounts=data;
            //console.log("all user account"+data);
            for (let i in this.accounts)
            {
              this.accountNumbers.push({value:(""+this.accounts[i].accountNo),viewValue:(""+this.accounts[i].accountNo)})
            }
          });
  }

  onFormSubmit()
  {
      this.action = this.statementForm.get('periodControl').value;
      let accountNo = this.statementForm.get('accountControl').value;
      let fetchTrans  = [];
      if(this.action === 'tenTransaction')
      {
          this._service.getLastTenTransaction({accountNo:""+accountNo}).subscribe(data=>{
           this.trans = data;
            console.log(this.trans[0].receiver['accountNo']);
          });
      }
      else if(this.action === 'allTransaction')
      {
          let accountNo = this.statementForm.get('accountControl').value;
            this._service.getAllTransaction({accountNo:""+accountNo}).subscribe( data=>
            {
              this.trans = data;
              console.log(this.trans[0].receiver['accountNo']);
            });
      }
  }
}
