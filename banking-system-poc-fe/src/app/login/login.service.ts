import { Injectable } from '@angular/core';
import {CustomerData} from '../login/DummyData'
import { CustomerLogin } from './CustomerLogin';
import { Observable,of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class LoginService 
{
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
}
