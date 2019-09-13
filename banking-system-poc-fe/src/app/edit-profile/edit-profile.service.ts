import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {  profileData} from './profileData';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EditProfileService {

  constructor(private _http:HttpClient) { }

  public getData():Observable<profileData>
  {
    //return of(data1);
    return this._http.get<profileData>('http://localhost:8089/customerDetails');
  }
  public updateData(updatedData):Observable<any>
  {
    return this._http.put('http://localhost:8089/updateUser',updatedData);
  }
}
