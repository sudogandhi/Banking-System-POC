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
    //console.log("Service"+JSON.stringify(newUser));
    this.newUserEntry.push(newUser);
    //console.log(this.newUserEntry);
    let newUserCred={username:newUser.username,password:newUser.password};
    console.log("New USer"+JSON.stringify(newUserCred));
    let customerData1 =JSON.parse(localStorage.getItem("UserCredentials"));
    console.log(localStorage.getItem("UserCredentials"));
    console.log("Customer"+customerData1);
    customerData1.push(newUserCred);
    localStorage.setItem("UserCredentials",JSON.stringify(customerData1));

    console.log(customerData1);
  }
}
