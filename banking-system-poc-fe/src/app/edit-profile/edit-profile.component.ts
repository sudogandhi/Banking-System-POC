import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {profileData} from './profileData';
import {EditProfileService} from './edit-profile.service';

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
    aadharCard:'',
    mobileNo:0,
    panCard:''
  }


  constructor(private _service:EditProfileService) {
    //console.log(document.getElementById('fname').nodeValue);
  }

  ngOnInit() {
    this._service.getData().subscribe(data=>this.fetchedData=data);
  }
  onSubmit()
  {

    alert('I am in submit')
  }
}
