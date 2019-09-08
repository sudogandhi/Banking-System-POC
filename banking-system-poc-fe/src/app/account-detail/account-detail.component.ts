import { Component, OnInit } from '@angular/core';
import {AccountDataService} from '../account-data.service'; 
@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.css']
})
export class AccountDetailComponent implements OnInit {
  constructor(private _detail:AccountDataService) { }
  value:any;
  header;
  balance:number
  hidebutton: boolean=true

  getValue(){
    this.value=this._detail.getData();
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
    this._detail.setData();
    this.getValue();
  }

}
