import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {UserViewModel} from "../model/userViewModel";
import {AuthorizationModel} from "../model/authorizationModel";

@Injectable()
// Data service
export class UserService { //todo create interface

  public account:UserViewModel;

  constructor(private http: HttpClient) {
  }

  authorization(authorizationModel:User): UserViewModel {
    this.http.post<UserViewModel>('/api/user/authorization',authorizationModel).subscribe(userViewModel =>{
      this.account = userViewModel;
    })
    console.log(this.account);
    return this.account;
  }

  // Ajax request for Project data
  getUsers(): Observable<UserViewModel[]> {
    return this.http.get<UserViewModel[]>('/api/users');
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api', user);
  }

  deleteUser(UserId: string): Observable<void> {
    return this.http.delete<void>('/api/user' + UserId);
  }

  getUserById(id: string): Observable<UserViewModel> {
    return this.http.get<UserViewModel>('/api/user/' + id);
  }

  // getUserByLoginPassword(login: string,password:string): Observable<User> {
  //   return this.http.get<User>('/api/user/login/password/' + id);
  // }

  getUserByIdAssignProject(id: string): Observable<UserViewModel> {
    return this.http.get<UserViewModel>('/api/user/project' + id);
  }
}
