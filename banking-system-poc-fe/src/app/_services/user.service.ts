import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../_models';

@Injectable()
export class UserService {
    UserInformation={}

    constructor(private http: HttpClient) { }

    register(user: User) {
        console.log(user);
        return this.http.post(`http://localhost:8089/register`, user);
    }

}
