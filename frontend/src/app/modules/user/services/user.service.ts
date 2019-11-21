import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable()
// Data service
export class UserService { //todo create interface

  public account:User;

  public user:User;
  constructor(private http: HttpClient) {
  }

  // Ajax request for Project data
  getUsers(): Observable<User[]> {
    return this.http.get<User[]>('/api/users');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api', user);
  }

  deleteUser(UserId: string): Observable<void> {
    return this.http.delete<void>('/api/user' + UserId);
  }

  getUserById(id: string): Observable<User> {
    return this.http.get<User>('/api/user/' + id);
  }

  // getUserByLoginPassword(login: string,password:string): Observable<User> {
  //   return this.http.get<User>('/api/user/login/password/' + id);
  // }

  getUserByIdAssignProject(id: string): Observable<User> {
    return this.http.get<User>('/api/user/project' + id);
  }
}
