import { Component, OnInit } from '@angular/core';
import {AccountDataService} from '../account-data.service'; 
import { Accdetail } from '../accdetail';
import { Router } from '@angular/router';
import { AuthenticationService } from '../_services';

@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.css']
})
export class AccountDetailComponent implements OnInit {
  constructor(private _service:AccountDataService, private authenticationService: AuthenticationService
    ,private router:Router) { }
  value:any;
  header;
  balance:boolean
  hidebutton: boolean=true
  public _detail:Accdetail[];
  item:any

  getValue(){
    this.value=this._service.getData();
    this.header=Object.keys(this.value[0]);
    
  }

  viewBalance(i: number)
  {
    console.log(i);
    document.getElementById("btn"+i).style.display='none';
    document.getElementById("txt"+i).style.visibility='visible';
    this.balance=true;
  }
  showtransaction(item:any)
  {
    console.log(item);
    this.router.navigate(['/transaction',item.accountNo])
  }

  ngOnInit() {
    this.authenticationService.redirectToHomePage();
    this._service.getAccountDetail().subscribe(data=> {this._detail = data; console.log("details of acc",this._detail)})
    // this._service.setData();
    // this.getValue();
  }

}
