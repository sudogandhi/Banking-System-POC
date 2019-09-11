import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Transfer} from '../transfer';

@Component({
  selector: 'app-money-transfer',
  templateUrl: './money-transfer.component.html',
  styleUrls: ['./money-transfer.component.css']
})
export class MoneyTransferComponent implements OnInit {
  accountNo: number[];
  moneyTransfer = new FormGroup(
    {accountNo: new FormControl('',[Validators.required]),
    ToAccountNo: new FormControl('',[Validators.required]),
      amount: new FormControl('',[Validators.required])
    });
  trans: Transfer;
  constructor() {

  }

  ngOnInit() {
    this.accountNo = [89324924109,9019216119];
  }
  onSubmit()
  {

    console.log('I am in submit');
    document.getElementById('message').style.display = 'block';
    this.trans = new Transfer();
    this.trans.sender=this.moneyTransfer.get('accountNo').value;
    this.trans.receiver=this.moneyTransfer.get('ToAccountNo').value;
    this.trans.amount=this.moneyTransfer.get('amount').value;
  }

}
