import { Component, OnInit } from '@angular/core';
import {AccountDataService} from '../account-data.service'
import { AuthenticationService } from '../_services';
@Component({
  selector: 'app-account-transaction',
  templateUrl: './account-transaction.component.html',
  styleUrls: ['./account-transaction.component.css']
})
export class AccountTransactionComponent implements OnInit {
  constructor(private _detail:AccountDataService, private authenticationService: AuthenticationService) { }
  value:any
  header;
  p:number =1;

  getValue(){
    this.value=this._detail.getTransaction()
    this.header=Object.keys(this.value[0]);
  }
  ngOnInit() {
    this.authenticationService.redirectToHomePage();
    this._detail.setTransaction();
    this.getValue()
  }

}

