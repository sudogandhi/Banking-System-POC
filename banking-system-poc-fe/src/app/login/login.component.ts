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
  generated_token:string='';
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
    
    this._service.getLoginToken(this.user).subscribe(data=>this.generated_token=data);
    localStorage.setItem("generated_token",this.generated_token);

    if(this.generated_token.length > 0 && this.user.username === this.foundRecord.username && this.user.password === this.foundRecord.password)
    {
      console.log("Successfully Logged In");
      console.log(localStorage.getItem("generated_token"));
      this.router.navigate(['/dashboard']);
    }
    else
    {
      alert("Incorrect Username or password");
    }

  }
}
