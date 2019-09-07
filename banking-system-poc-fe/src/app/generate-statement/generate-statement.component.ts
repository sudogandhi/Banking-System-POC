import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-generate-statement',
  templateUrl: './generate-statement.component.html',
  styleUrls: ['./generate-statement.component.css']
})
export class GenerateStatementComponent implements OnInit {
  accountType = '';
  dateRange = '';
  monName = '';
  from = '';
  to = '';
  nameOfMonth = '';
  month: string[];
  statement: any[];
  constructor() {
  }
  selectAccountType(event: any) {
    this.selectAccountType = event.target.value;
    console.log(this.accountType);
  }

  monthName(event: any) {
    this.monName = event.target.value;
    console.log(this.monName);
  }
  selectDateRange(event: any) {
    this.dateRange = event.target.value;
    console.log(this.dateRange);
    if (this.dateRange === 'monthly') {
      const x = document.getElementById('comDate').style.display;
      if (x === 'none') {
        document.getElementById('monthSelect').style.display = 'block';
        const i = document.getElementById('mon');
        console.log(i.nodeValue);
      } else {
        document.getElementById('comDate').style.display = 'none';
        document.getElementById('monthSelect').style.display = 'block';
      }
    } else if (this.dateRange === 'daterange') {
      const y = document.getElementById('monthSelect').style.display;
      if (y === 'none') {
          document.getElementById('comDate').style.display = 'block';

      } else {
        document.getElementById('monthSelect').style.display = 'none';
        document.getElementById('comDate').style.display = 'block';
      }
      // document.getElementById('toDate').style.display = 'block';
    }
  }
  ngOnInit() {
    this.month = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August',
      'September', 'October', 'November', 'December'];

    this.statement = [
      {
        accountNo : 67389278,
        transactionId : 'hdcjwhdkcj2131',
        outDate : '2019-09-12'
      },
      {
        accountNo : 4325657,
        transactionId : 'iowqoiowjio22',
        outDate : '2019-12-12'
      }
    ];
  }
  getStatements()
  {
  console.log( this.from);
  console.log(this.to);
  console.log(this.nameOfMonth);
  document.getElementById('tableId').style.display = 'block';
  }

}
