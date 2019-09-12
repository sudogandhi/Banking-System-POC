import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

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
  constructor() {
  }

  ngOnInit() {

    this.branchInfo = [
        {branchName:'Kothaguda', ifscCode:'DBS0001', id:123},
        {branchName:'Gachibowli', ifscCode:'DBS0002', id:124},
        {branchName:'Gowlidoddy', ifscCode:'DBS0003', id:125},
        {branchName:'Kondapur', ifscCode:'DBS0004', id:126},
        {branchName:'Madhapur', ifscCode:'DBS0005', id:127},
        {branchName:'Secunderabad', ifscCode:'DBS0006', id:128}
      ];
  }
  onSubmit()
  {
    console.log("I am in submit");
    document.getElementById('message').style.display = 'block';
  }

}
