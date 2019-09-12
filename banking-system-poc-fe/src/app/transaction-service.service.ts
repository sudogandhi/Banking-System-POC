import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs';
import {Transaction} from './transaction';
import {trans} from './transaction-mock.data';

@Injectable({
  providedIn: 'root'
})
export class TransactionServiceService {

  constructor() { }
  public getTransaction(): Observable<Transaction[]>
  {
      return of(trans);
  }
}
