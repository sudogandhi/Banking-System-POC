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

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
    }

    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.loading = true;

        console.log(this.authenticationService.executeAuthenticationService(this.f.username.value, this.f.password.value));

        // this.authenticationService.login(this.f.username.value, this.f.password.value)
        //     .pipe(first())
        //     .subscribe(
        //         data => {
        //             this.router.navigate([this.returnUrl]);
        //         },
        //         error => {
        //             this.alertService.error(error);
        //             this.loading = false;
        //         });
    }

  }
}
