import { Injectable } from '@angular/core';
import {CustomerData} from '../login/DummyData'
import { CustomerLogin } from './CustomerLogin';
import { Observable,of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LoginService 
{
  generated_token:string='';
  customerData : CustomerLogin[]=[];

  constructor() { }

  getData():Observable<CustomerLogin[]>
  {
    return of(JSON.parse(localStorage.getItem("UserCredentials")));
  }

  findEntry(username:string):Observable<CustomerLogin>
  {
    this.customerData=JSON.parse(localStorage.getItem("UserCredentials"));
    return of(this.customerData.find(entry=>{return entry.username === username}));
  }

  getLoginToken(user:CustomerLogin):Observable<string>
  {
    this.generated_token='dsgeruiuretkjrbg';
    return of(this.generated_token);
  }
}
