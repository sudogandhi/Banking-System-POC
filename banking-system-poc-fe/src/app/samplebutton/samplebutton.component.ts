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
  public show0:boolean = false;
 public showvar1:boolean=false;
 public showvar2:boolean=false;
 public showvar3:boolean=false;
 @Input() Valuetoggle:boolean=false;
public accounts = [];
public AllCustomers = [];

 show1(){
  this.showvar1=true;
  this.showvar2=false;
  this.showvar3=false;
 }
 show2(){
  this.showvar1=false;
  this.showvar2=true;
  this.showvar3=false;
 }
 show3(){
  this.showvar1=false;
  this.showvar2=false;
  this.showvar3=true;
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
  // customerData:any=[
  //   {name:"Ashwini",address:"Pune",profile:"Application D",status:false},
  //   {name:"Rachana",address:"Nagpur",profile:"Data scientists",status:false},
  //   {name:"Pradnya",address:"Kolhapur",profile:"Application D",status:false},
  //   {name:"Shivani",address:"Kolhapur",profile:"Application D",status:false},

  // ]
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
  constructor(private _allaccountservice : AllaccountsService , private _allcustomerservive : AllcustomerDETService){}
  
  ngOnInit() {
    this._allaccountservice.getAllAccountData()
    .subscribe(data =>{this.accounts = data;console.log(this.accounts)});

    this._allcustomerservive.getAllCustomerData()
    .subscribe(data =>{this.AllCustomers = data;console.log(this.AllCustomers)});

  }


}
