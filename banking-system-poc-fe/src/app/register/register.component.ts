import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, UserService } from '../_services';

@Component({templateUrl: 'register.component.html'})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
    private alertService: AlertService) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', [Validators.required, Validators.min(6)]],
      email : ['',Validators.required],
      mobileNo : ['',[Validators.required,Validators.min(10)]],
      adharCard : ['',Validators.required],
      panCard : ['',Validators.required]
    });
  }

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;
    console.log("in submit");
    // stop here if form is invalid
    if (this.registerForm.invalid) {
      console.log('If invalid');
      return;
    }

    this.loading = true;
    console.log("---> :"+ this.registerForm.value);
    this.userService.register(this.registerForm.value)
      .subscribe(
        data => {
          console.log("data : "+data);
          this.alertService.success('Registration successful', true);
          this.router.navigate(['/login']);
        },
        error => {
          console.log('in error');
          //this.alertService.error(error);
          this.loading = false;
        });
  }
}
