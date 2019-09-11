import { Component, OnInit } from '@angular/core';
import { CustomerRegister } from './CustomerRegister';
import { NewUserEntryService } from './new-user-entry.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser:CustomerRegister={firstname:"",lastname:"",email:"",phone1:0,phone2:0,username:"",password:""};
  constructor(private _service:NewUserEntryService,private router:Router) { }

  ngOnInit() 
  {}

  onFormSubmit()
  {
    console.log(this.newUser);
    this._service.save(this.newUser);
    console.log(localStorage.getItem("UserCredentials"));
    this.router.navigate(['/login']);

  }
}
