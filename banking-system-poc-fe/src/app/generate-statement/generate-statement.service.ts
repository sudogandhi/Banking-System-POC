import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GenerateStatementService {

  constructor(private _http:HttpClient) { }

  public getAccountNumbers():Observable<any>
  {
    return this._http.get('http://localhost:8089/getAllAccounts');
  }
  public getLastTenTransaction(accountNo):Observable<any>
  {
    return this._http.post('http://localhost:8089/lastTenTransactions',accountNo);
  }

}
