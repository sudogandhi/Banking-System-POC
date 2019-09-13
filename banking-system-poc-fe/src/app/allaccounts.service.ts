import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Accounts } from './accounts';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AllaccountsService {

  baseUrl="http://localhost:8089/admin/listAccounts/0";
  constructor(private http:HttpClient){}

  //to get all accounts data
  getAllAccountData(): Observable<Accounts[]>
  {
    let headers = new HttpHeaders({'Status': 'ALL'});
    console.log(this.http.get<Accounts[]>(this.baseUrl));
    return this.http.get<Accounts[]>(this.baseUrl, {headers});
    
  }
  //to get activated account data
  getAllActivatedData(): Observable<Accounts[]>
  {
    let headers = new HttpHeaders({'Status': 'ACTIVATED'});
    console.log(this.http.get<Accounts[]>(this.baseUrl));
    return this.http.get<Accounts[]>(this.baseUrl, {headers});
    
  }
   //to get all deactivated account data
   getAllDectivatedData(): Observable<Accounts[]>
   {
     let headers = new HttpHeaders({'Status': 'DEACTIVATED'});
     console.log(this.http.get<Accounts[]>(this.baseUrl));
     return this.http.get<Accounts[]>(this.baseUrl, {headers});
     
   }
    // get all unblocked account data
    getAllblockedData(): Observable<Accounts[]>
    {
      let headers = new HttpHeaders({'Status': 'BLOCKED'});
      console.log(this.http.get<Accounts[]>(this.baseUrl  ));
      return this.http.get<Accounts[]>(this.baseUrl, {headers});
    }
  
   // get all unblocked account data
   getAllUnblockedData(): Observable<Accounts[]>
   {
     let headers = new HttpHeaders({'Status': 'UNBLOCKED'});
     console.log(this.http.get<Accounts[]>(this.baseUrl));
     return this.http.get<Accounts[]>(this.baseUrl, {headers});
     
   }
   aprovedAccount(accountNo:Number):Observable<any>
   {
    console.log(accountNo);
     return this.http.post('http://localhost:8089/activateAccount',{accountNo:""+accountNo});
     
   }
  
}
