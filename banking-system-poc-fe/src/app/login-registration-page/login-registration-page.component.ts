import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-registration-page',
  templateUrl: './login-registration-page.component.html',
  styleUrls: ['./login-registration-page.component.css']
})
export class LoginRegistrationPageComponent implements OnInit {

  notShow:boolean=false;
  success:boolean=false;

  constructor(private router : Router) { }

  ngOnInit() {
  }

  navigateToDashboard()
  {
    // this.notShow=true;
    // this.success=true;
    // this.router.navigate(['/dashboard']);

  }

  onClick(action:string)
  {
    if(action == 'login')
    {
      // let lbtn = document.getElementsByClassName("btn-group");
      this.router.navigate(['/login']);
    }
    else if(action == 'register')
    {
      this.router.navigate(['/register']);
    }
  }
}
