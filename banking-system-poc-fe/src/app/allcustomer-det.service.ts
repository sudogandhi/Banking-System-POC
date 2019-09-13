import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CustomerDET } from './customer-det';


@Injectable({
  providedIn: 'root'
})
export class AllcustomerDETService {
  baseUrl="http://localhost:8089/admin/listCustomers/1";
  constructor(private http:HttpClient){}

  getAllCustomerData(): Observable<CustomerDET[]>
  {
    let headers = new HttpHeaders({'Status': 'ALL'});
    console.log(this.http.get<CustomerDET[]>(this.baseUrl));
    return this.http.get<CustomerDET[]>(this.baseUrl, {headers});
  }
}
