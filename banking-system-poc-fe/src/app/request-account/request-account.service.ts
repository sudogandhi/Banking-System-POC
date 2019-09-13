import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RequestAccountService {

  constructor(private _http:HttpClient) { }

  public getBranches():Observable<any>
  {
    return this._http.get<any>('http://localhost:8089/getAllBranchesName');
  }
  public createAccount(requestAccountInfo):Observable<any>
  {
    return this._http.post('http://localhost:8089/createAccount',requestAccountInfo);
  }

}
