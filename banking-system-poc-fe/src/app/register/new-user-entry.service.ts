import { Injectable } from '@angular/core';
import { CustomerRegister } from './CustomerRegister';
import { Observable } from 'rxjs';
// import { Observable } from 'rxjs';
// import { CustomerRegister } from './CustomerRegister';
// import { newUserEntry } from './DummyRegisterEntry';

@Injectable({
  providedIn: 'root'
})
export class NewUserEntryService {
  newUserEntry:CustomerRegister[]=[];
  constructor() { }

  public save(newUser)
  {
    console.log(newUser); 
    this.newUserEntry.push(newUser);
    let newUserCred={username:newUser.username,password:newUser.password};
    let customerData1 =JSON.parse(localStorage.getItem("UserCredentials"));

    customerData1.push(newUserCred);
    localStorage.setItem("UserCredentials",JSON.stringify(customerData1));

    console.log(customerData1);
  }
}
