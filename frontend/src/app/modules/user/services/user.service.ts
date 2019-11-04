import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable()
// Data service
export class UserService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for Project data
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/ba');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api/user', user);
  }

  deleteUser(UserId: string): Observable<void> {
    return this.http.delete<void>('/api/ba/' + UserId);
  }

  getUserById(id: string): Observable<User> {
    return this.http.get<User>('/api/ba/' + id);
  }

}
