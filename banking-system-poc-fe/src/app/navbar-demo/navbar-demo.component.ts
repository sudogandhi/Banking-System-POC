import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar-demo',
  templateUrl: './navbar-demo.component.html',
  styleUrls: ['./navbar-demo.component.css']
})
export class NavbarDemoComponent implements OnInit {




  constructor(private router:Router) {
  }

  ngOnInit(): void {
  }

  logout()
  {
    localStorage.removeItem("token");
    //console.log(localStorage.getItem("token"));
    this.router.navigate(['/home']);

  }
}
