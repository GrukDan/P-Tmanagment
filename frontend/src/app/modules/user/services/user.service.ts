import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {UserViewModel} from "../model/userViewModel";
import {AuthorizationModel} from "../model/authorizationModel";
import {tap} from "rxjs/operators";

@Injectable()
// Data service
export class UserService { //todo create interface

  public account: UserViewModel;

  constructor(private http: HttpClient) {
  }

  authorization(authorizationModel: User): Observable<UserViewModel> {
    return this.http.post<UserViewModel>('/api/user/authorization', authorizationModel).pipe(
      tap(userViewModel => {
        this.account = userViewModel;
      })
    );
  }

  getUsers(): Observable<UserViewModel[]> {
    return this.http.get<UserViewModel[]>('/api/users');
  }

  getUsersSortByName(page:number,size:number,direction:boolean): Observable<UserViewModel[]> {
    const asc:number = 1;
    const desc:number = 0;

    if(direction)
      return this.http.get<UserViewModel[]>('/api/users/name/' + page + "/" + size + "/" + asc);
    else return this.http.get<UserViewModel[]>('/api/users/name/' + page + "/" + size + "/" + desc);

    // if(direction)
    // return this.http.get<UserViewModel[]>('/api/users/name/',
    //   {params:new HttpParams().set("page",page.toString()).set("size",size.toString()).set("direction",asc.toString())});
    // else return this.http.get<UserViewModel[]>('/api/users/name/',
    //   {params:new HttpParams().set("page",page.toString()).set("size",size.toString()).set("direction",desc.toString())});
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api', user);
  }

  saveUserViewModel(userViewModel: UserViewModel): Observable<UserViewModel> {
    return this.http.post<UserViewModel>('/api/userviewmodel', userViewModel);
  }

  deleteUser(UserId: string): Observable<void> {
    return this.http.delete<void>('/api/user/delete/' + UserId);
  }

  getUserById(id: string): Observable<UserViewModel> {
    return this.http.get<UserViewModel>('/api/user/' + id);
  }

  // getUserByLoginPassword(login: string,password:string): Observable<User> {
  //   return this.http.get<User>('/api/user/login/password/' + id);
  // }

  getUserByIdAssignProject(id: string): Observable<UserViewModel[]> {
    return this.http.get<UserViewModel[]>('/api/user/project/' + id);
  }
}
