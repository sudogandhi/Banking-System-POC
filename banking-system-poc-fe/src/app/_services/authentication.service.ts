import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';

@Injectable()
export class AuthenticationService {
  constructor(private http: HttpClient) {
  }

   login(username: string, password: string) {
    return this.http.post<any>(`/users/authenticate`, {username: username, password: password})
      .pipe(map(user => {
        // login successful if there's a jwt token in the response
        if (user && user.token) {
          // store user details and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
        }

        return user;
      }));
  }

  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }

  executeAuthenticationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    console.log(basicAuthHeaderString);
    let headers = new HttpHeaders({
      Authorization: basicAuthHeaderString
    });
    console.log(this.http.get<AuthenticationBean>(`http://localhost:8089/basicauth`, {headers}).subscribe());
    this.http.get(`http://localhost:8089/getAllCustomers`,{headers}).subscribe(
      (response: Response) => {
        console.log(response);
      }
    );
  }
}

export class AuthenticationBean {
  constructor(public message: string) {}
}
