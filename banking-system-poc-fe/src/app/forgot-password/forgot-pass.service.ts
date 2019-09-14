import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForgotPassService {

  constructor(private _http:HttpClient) { }
  public changeUserPass(username:string):Observable<any>
  {
    return this._http.post('http://localhost:8089/requestForgetPassword',username);
  }
}
