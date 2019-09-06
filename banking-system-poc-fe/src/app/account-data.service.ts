import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountDataService {
  arr=[{
    "AccountNo": 326541254,
    "Branch":"Mumbai",
    "Balance":10000,
    "transactions":[{
      "date":"02-09-2019",
      "referencechequenumber":784587457843,
      "debit":192,
      "credit":0,
      "balance":800
    },
  {
    "date":"03-09-2019",
    "referencechequenumber":788735675376,
    "debit":0,
    "credit":8767,
    "balance":376
  },
  {
    "date":"03-09-2019",
    "referencechequenumber":78875675376,
    "debit":874,
    "credit":0,
    "balance":198628
  },
  {
    "date":"03-09-2019",
    "referencechequenumber":78875675376,
    "debit":0,
    "credit":1008,
    "balance":198628
  },
  {
    "date":"03-09-2019",
    "referencechequenumber":78875675376,
    "debit":874,
    "credit":0,
    "balance":198628
  }]
  }]
  userdetail;
  transactiondetail;
  setData(){
    this.userdetail=this.arr;
  }
  getData()
  {
    return this.userdetail; 
  }
  setTransaction(){
    this.transactiondetail=this.arr[0].transactions;
    console.log(this.transactiondetail);
  }
  getTransaction()
  {
    return this.transactiondetail;
  }
}
