import {AfterContentInit, Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RequestAccountService} from './request-account.service';

@Component({
  selector: 'app-request-account',
  templateUrl: './request-account.component.html',
  styleUrls: ['./request-account.component.css']
})
export class RequestAccountComponent implements OnInit {

  requestAccount = new FormGroup(
    {
      accountType: new FormControl('',[Validators.required]),
      branchName: new FormControl('',[Validators.required])
    });
  branchInfo: any[];
  constructor(private _service:RequestAccountService) {
  }
  branchData: any = [];
  ngOnInit() {

    this.branchInfo = [
        {branchName:'Kothaguda', ifscCode:'DBS0001', id:123},
        {branchName:'Gachibowli', ifscCode:'DBS0002', id:124},
        {branchName:'Gowlidoddy', ifscCode:'DBS0003', id:125},
        {branchName:'Kondapur', ifscCode:'DBS0004', id:126},
        {branchName:'Madhapur', ifscCode:'DBS0005', id:127},
        {branchName:'Secunderabad', ifscCode:'DBS0006', id:128}
      ];

    this._service.getBranches().subscribe(data=>{
      this.branchData=data;
      // console.log(data);
    });
    // console.log(this.branchData);
  }
  onSubmit()
  {

    console.log("I am in submit");
    console.log(this.requestAccount.get('accountType').value+" "+this.requestAccount.get('branchName').value);
    let requestAccountInfo  = {
      accountType: this.requestAccount.get('accountType').value,
      branchId: this.requestAccount.get('branchName').value
    };
    this._service.createAccount(requestAccountInfo).subscribe(data=>console.log(data));
    document.getElementById('message').style.display = 'block';
  }


}
