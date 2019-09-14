import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {profileData} from './profileData';
import {EditProfileService} from './edit-profile.service';
import { AuthenticationService } from '../_services';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {
  editForm = new FormGroup(
    {
      firstname: new FormControl('',[Validators.required]),
      lastname: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required]),
      phone: new FormControl('',[Validators.required]),

    }
  );
  personForm = new FormGroup(
    {
      aadhar: new FormControl('',[Validators.required]),
      pan: new FormControl('',[Validators.required])
    }
  )
  fetchedData: profileData = {
    firstName:'',
    lastName:'',
    email:'',
    adharCard:'',
    mobileNo:0,
    panCard:''
  }


  constructor(private _service:EditProfileService,private authenticationService: AuthenticationService) {
    //console.log(document.getElementById('fname').nodeValue);
  }

  ngOnInit() {
    this.authenticationService.redirectToHomePage();
    this._service.getData().subscribe(data=>this.fetchedData=data);
  }
  onSubmit()
  {
    console.log(this.editForm.value);

   let updatedData = {firstName: this.editForm.get('firstname').value,
                      lastName:this.editForm.get('lastname').value,
                      email:this.editForm.get('email').value,
                      mobileNo: (""+this.editForm.get('phone').value)};
    this._service.updateData(updatedData).subscribe(data=>console.log(data));
    alert('I am in submit')
  }
}
