import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Transfer} from '../transfer';
import {GenerateStatementService} from '../generate-statement/generate-statement.service';
import {AccountType} from '../generate-statement/generate-statement.component';
import {MoneyTransferService} from './money-transfer.service';

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
  accountNumbers:AccountType[]=[];
  message: string='';
  accounts: any='';
  sender: string='';
  receiver: string='';
  amount: number=0;

  constructor(private _service:GenerateStatementService,private _moneyTransfer:MoneyTransferService) {

  }

      ngOnInit() {
              this.accountNo = [89324924109,9019216119];
              this._service.getAccountNumbers().subscribe(data=>{
                this.accounts=data;
                //console.log("all user account"+data);
                for (let i in this.accounts)
                {
                  //console.log(this.accounts[i].accountNo);
                  this.accountNumbers.push({value:(""+this.accounts[i].accountNo),viewValue:(""+this.accounts[i].accountNo)})
                }
              });
      }
      onSubmit()
      {

        console.log('I am in submit');
        console.log(this.moneyTransfer.get('accountNo').value);
        console.log(this.moneyTransfer.get('ToAccountNo').value);
        console.log(this.moneyTransfer.get('amount').value);

        let monetTransferInfo = {
          sender: (""+this.moneyTransfer.get('accountNo').value),
          receiver: (""+this.moneyTransfer.get('ToAccountNo').value),
          amount: (""+this.moneyTransfer.get('amount').value)
        }
        this._moneyTransfer.transferMoney(monetTransferInfo).subscribe(
          (data) => {
            console.log("data ::::::::" + data)
          },
          (error => {
            console.log(error);
            this.message=error;
            if(error==='OK')
            {
              this.message=this.message+=" Transaction Successfull!!";
              document.getElementById('message').style.display
            }
            else
            {
              document.getElementById('message').style.display='block';
            }
          })
        );

      }

}
