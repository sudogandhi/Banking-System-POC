import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Role } from '../_models/role';

@Component({
  selector: 'app-redirection-component',
  templateUrl: './redirection-component.component.html',
  styleUrls: ['./redirection-component.component.css']
})
export class RedirectionComponentComponent implements OnInit {

  constructor(private router: Router,private http: HttpClient) { }

  ngOnInit() {

    this.http.get<Role>('http://localhost:8089/getLoggedInUserRole').subscribe(
      (response) => {
        console.log(response.role);
        if(response.role ==="CUSTOMER") {
          this.router.navigate(['/customer_home']);
        }
        else {
          this.router.navigate(['/admin']);
        }
      }
    );
  }

}
