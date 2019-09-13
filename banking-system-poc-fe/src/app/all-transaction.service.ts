import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AllTransactionService {

  constructor(private _http:HttpClient) { }

  getAllTransactions():Observable<any>
  {
    return this._http.get<any>('http://localhost:8089/allTransactions');
  }


}
