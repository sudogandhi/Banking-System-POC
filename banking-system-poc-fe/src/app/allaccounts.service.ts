import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Accounts } from './accounts';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AllaccountsService {

  baseUrl="http://localhost:8089/admin/listAccounts/1";
  constructor(private http:HttpClient){}

  getAllAccountData(): Observable<Accounts[]>
  {
    console.log(this.http.get<Accounts[]>(this.baseUrl));
    return this.http.get<Accounts[]>(this.baseUrl);
    
  }
  
  
}
