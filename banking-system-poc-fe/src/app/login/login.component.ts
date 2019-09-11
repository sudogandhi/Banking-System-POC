import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { CustomerLogin } from './CustomerLogin';
import { Alert } from 'selenium-webdriver';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //username:string;
  user:CustomerLogin={username:"",password:""};
  foundRecord:CustomerLogin;
  constructor(private _service :LoginService,private router : Router) { }

  ngOnInit() 
  {
    //this.onFormSubmit();
  }

  onFormSubmit()
  {
    // let data:CustomerLogin;
    this._service.findEntry(this.user.username).subscribe(data=>this.foundRecord = data);
    console.log(this.foundRecord);
    
    if(this.user.username === this.foundRecord.username && this.user.password === this.foundRecord.password)
    {
      console.log("Successfully Logged In");
      this.router.navigate(['/dashboard']);
    }
    else
    {
      alert("Incorrect Username or password");
    }

  }
}
