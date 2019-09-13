import { Component, OnInit } from '@angular/core';
import {AccountDataService} from '../account-data.service'; 
import { Accdetail } from '../accdetail';

@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.css']
})
export class AccountDetailComponent implements OnInit {
  constructor(private _service:AccountDataService) { }
  value:any;
  header;
  balance:number
  hidebutton: boolean=true
  public _detail:Accdetail[];

  getValue(){
    this.value=this._service.getData();
    this.header=Object.keys(this.value[0]);
  }

  viewBalance()
  {
    console.log(this.hidebutton)
    this.hidebutton = false
    this.balance=this.value[0].Balance
  }
  showtransaction()
  {
    console.log("showtrabsaction")

  }

  ngOnInit() {
    this._service.getAccountDetail().subscribe(data=> {this._detail = data; console.log("details of acc",this._detail)})
    this._service.setData();
    this.getValue();
  }

}
