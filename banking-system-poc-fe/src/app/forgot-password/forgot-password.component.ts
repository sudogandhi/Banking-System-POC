import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ForgotPassService} from './forgot-pass.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  changePass = new FormGroup(
    {
      username: new FormControl('',[Validators.required])
    }
  );
  message: string='';
  username: string='';
  constructor(private _service:ForgotPassService,private router:Router) {

  }
  changePassword()
  {
      this.username=this.changePass.get('username').value;
      this._service.changeUserPass(this.username).subscribe((data)=> {
        console.log(data);
        },
        (error => {
          console.log(error);
          this.message=error;
          if(error ==='OK')
          {
            this.message=this.message+" "+"Please Check your mail!!";
            document.getElementById('error').style.display='block';
          }
          else
          {
              document.getElementById('error').style.display='block';
          }
        })
      );

  }
  ngOnInit() {
  }

  backToLogin()
  {
      this.router.navigate(['/login']);
  }

}
