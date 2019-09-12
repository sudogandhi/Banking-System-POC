import {Component, OnInit} from '@angular/core';
import {LoginService} from './login.service';
import {CustomerLogin} from './CustomerLogin';
import {Alert} from 'selenium-webdriver';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AlertService, AuthenticationService} from '../_services';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  generated_token: string = '';
  user: CustomerLogin = {username: '', password: ''};
  foundRecord: CustomerLogin;

  constructor(private _service: LoginService,
              private router: Router,
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private authenticationService: AuthenticationService,
              private alertService: AlertService) {
  }


  ngOnInit() {
    this.loginForm = new FormGroup(
      {
        username: new FormControl('',[Validators.required]),
        password: new FormControl('',[Validators.required])
      }
    );
    let token = localStorage.getItem('token');

    if(token) {
      this.router.navigate(['/dashboard']);
    }
    // this.onFormSubmit();
  }

  onFormSubmit() {
    // let data:CustomerLogin;
    this._service.findEntry(this.user.username).subscribe(data => this.foundRecord = data);
    console.log(this.foundRecord);

    this._service.getLoginToken(this.user).subscribe(data => this.generated_token = data);
    localStorage.setItem('generated_token', this.generated_token);

    // get return url from route parameters or default to '/'
    this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
  }

  // convenience getter for easy access to form fields
  get f() {
    return this.loginForm.controls;
  }

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
