import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import { data1, profileData} from './profileData';

@Injectable({
  providedIn: 'root'
})
export class EditProfileService {

  constructor() { }

  public getData():Observable<profileData>
  {
    return of(data1);
  }
}
