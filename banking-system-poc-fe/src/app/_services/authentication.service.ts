import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import { ActivatedRoute, Router } from '@angular/router';

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient, private router: Router) {
  }

  //  login(username: string, password: string) {
  //   return this.http.post<any>(`/users/authenticate`, {username: username, password: password})
  //     .pipe(map(user => {
  //       // login successful if there's a jwt token in the response
  //       if (user && user.token) {
  //         // store user details and jwt token in local storage to keep user logged in between page refreshes
  //         localStorage.setItem('currentUser', JSON.stringify(user));
  //       }

  //       return user;
  //     }));
  // }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('token');
  }

  executeAuthenticationService(username, password) {
  
    console.log(this.http.post<AuthenticationBean>(`http://localhost:8089/login`, {"username":username, "password":password}).subscribe(
      (response) => {
        if(response) {
          localStorage.setItem('token',response.token);
          this.router.navigate(['/dashboard']);
        }
      }
    ));

    this.http.get('http://localhost:8089/');
  }
}

export class AuthenticationBean {
  token: string;
  constructor(token: string) {
    this.token = token;
  }
}
