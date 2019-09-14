import { Component, OnInit } from '@angular/core';
import {AccountDataService} from '../account-data.service';
import { ActivatedRoute } from '@angular/router';
import {HttpParams} from '@angular/common/http';

import { AuthenticationService } from '../_services';
@Component({
  selector: 'app-account-transaction',
  templateUrl: './account-transaction.component.html',
  styleUrls: ['./account-transaction.component.css']
})
export class AccountTransactionComponent implements OnInit {
  constructor(private _detail:AccountDataService, private authenticationService: AuthenticationService
    , private activeRoute:ActivatedRoute) { }
  value:any
  header;
  p:number =1;
  accNo:number;
  getValue(){
    // this.value=this._detail.getTransaction()
    // this.header=Object.keys(this.value[0]);
  }
  ngOnInit() {
    this.authenticationService.redirectToHomePage();

    // this._detail.setTransaction();
    // this.getValue()
    this.accNo=parseInt(this.activeRoute.snapshot.paramMap.get('id'));
    let body = {accountNo : ""+this.accNo};
    console.log(body)
    console.log('accno',this.accNo)
    this._detail.getTransactionDetail(body).subscribe(data=> {this.value = data; console.log("transaction details",this.value)})
  }

}

