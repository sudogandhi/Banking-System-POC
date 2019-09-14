import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MoneyTransferService {

  constructor(private _http:HttpClient) { }

  public transferMoney(moneyTransferInfo)
  {
    return this._http.post('http://localhost:8089/transaction/transfer',moneyTransferInfo);
  }
}
