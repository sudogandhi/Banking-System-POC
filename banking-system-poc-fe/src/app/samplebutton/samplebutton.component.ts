import { Component, OnInit, Input } from '@angular/core';
import { AllaccountsService } from '../allaccounts.service';
import { AllcustomerDETService } from '../allcustomer-det.service';

// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
// import {FormBuilder, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-samplebutton',
  templateUrl: './samplebutton.component.html',
  styleUrls: ['./samplebutton.component.css'],

})

export class SamplebuttonComponent implements OnInit {
 public show:boolean = true;
 public showvar1:boolean=false;
 public showvar2:boolean=false;
 public showvar3:boolean=false;
 public showvar4:boolean=false;
 public showvar5:boolean=false;

 @Input() Valuetoggle:boolean=false;
public accounts = [];
public AllCustomers = [];
public activeaccounts = [];
public deactiveaccounts = [];
public blockedaccounts = [];
public  unblockedaccounts = [];

 show1(){
  this.showvar1=true;
  this.showvar2=false;
  this.showvar3=false;
  this.showvar4=false;
  this.showvar5=false;

 }
 show2(){
  this.showvar1=false;
  this.showvar2=true;
  this.showvar3=false;
  this.showvar4=false;
  this.showvar5=false;
 }
 show3(){
  this.showvar1=false;
  this.showvar2=false;
  this.showvar3=true;
  this.showvar4=false;
  this.showvar5=false;
 }
 show4(){
  this.showvar1=false;
  this.showvar2=false;
  this.showvar3=false;
  this.showvar4=true;
  this.showvar5=false;
 }
 show5(){
  this.showvar1=false;
  this.showvar2=false;
  this.showvar3=false;
  this.showvar4=false;
  this.showvar5=true;
 }
 
  // toggle() {
  //   this.show = !this.show;

  // }
  // valueChange()
  // {
  //   console.log("Toggle button")
  // }
  logout()
  {
    console.log("Hello")
  }
  //  onChange(name:string)
  // {
  //   console.log(name);
  //   this.customerData.forEach(element => {
  //     if(element.name == name)
  //     {
  //       console.log(element.status)
  //        element.status = ! element.status
  //       this.Valuetoggle=element.status
  //       console.log(element.status)
  //     }
  //   });

  // }
  constructor(private _allaccountservice : AllaccountsService , private _allcustomerservive : AllcustomerDETService,
    private _allactivatedservice : AllaccountsService,private _alldeactivatedservice : AllaccountsService,
    private _allunblockedservice : AllaccountsService,
    private _allblockedservice : AllaccountsService){}
  
  ngOnInit() {
    //get all acocounts data
    this._allaccountservice.getAllAccountData()
    .subscribe(data =>{this.accounts = data;console.log(this.accounts)});

    // get all customers data
    this._allcustomerservive.getAllCustomerData()
    .subscribe(data =>{this.AllCustomers = data;console.log(this.AllCustomers)});

    //get all activated accounts 
    this._allactivatedservice.getAllActivatedData()
    .subscribe(data =>{this.activeaccounts = data;console.log(this.activeaccounts)});

    //get all deactivated accounts
    this._alldeactivatedservice.getAllDectivatedData()
    .subscribe(data =>{this.deactiveaccounts = data;console.log(this.deactiveaccounts)});

     //get all blocked accounts
     this._allblockedservice.getAllblockedData()
     .subscribe(data =>{this.blockedaccounts = data;console.log(this.blockedaccounts)});

    //get all unblocked accounts
     this._allunblockedservice.getAllUnblockedData()
    .subscribe(data =>{this.unblockedaccounts = data;console.log(this.unblockedaccounts)});

    


  }

  onChange(accountno){
    //call api
    console.log(accountno+'in tss file');
    this._allaccountservice.aprovedAccount(accountno).subscribe(data=>
      console.log(data)
      );

  }

}
