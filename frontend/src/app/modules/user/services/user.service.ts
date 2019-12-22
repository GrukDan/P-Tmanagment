import {Inject, Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";
import {UserViewModel} from "../model/userViewModel";
import {AuthorizationModel} from "../model/authorizationModel";
import {tap} from "rxjs/operators";
import {UserPaginationModel} from "../model/userPagnationModel";
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";

@Injectable()
export class UserService {

  private account: UserViewModel;
  private key:string = "account";

  constructor(private http: HttpClient,
              @Inject(LOCAL_STORAGE) private storage: WebStorageService) {
  }

  authorization(authorizationModel: AuthorizationModel): Observable<UserViewModel> {
    return this.http.post<UserViewModel>('/api/user', authorizationModel).pipe(
      tap(userViewModel => {
        this.account = userViewModel;
        this.storage.set(this.key,this.account);
      })
    );
  }

  public getAccount():UserViewModel{
    return this.storage.get(this.key);
  }

  public removeAccount():void{
    this.storage.remove(this.key);
  }

  getUsersSort(parameter:string,page:number,size:number,direction:boolean): Observable<UserPaginationModel> {
    const asc:number = 1;
    const desc:number = 0;
    if(direction)
    return this.http.get<UserPaginationModel>('/api/users',
      {params:new HttpParams()
          .set("parameter",parameter)
          .set("page",page.toString())
          .set("size",size.toString())
          .set("direction",asc.toString())});
    else return this.http.get<UserPaginationModel>('/api/users',
      {params:new HttpParams()
          .set("parameter",parameter)
          .set("page",page.toString())
          .set("size",size.toString())
          .set("direction",desc.toString())});
  }

  saveUser(user: User): Observable<User> {
    return this.http.post<User>('/api', user);
  }

  saveUserViewModel(userViewModel: UserViewModel): Observable<UserViewModel> {
    return this.http.post<UserViewModel>('/api/userviewmodel', userViewModel);
  }

  deleteUser(userId: string): Observable<void> {
    return this.http.delete<void>('/api/user/' + userId);
  }

  getUserById(id: string): Observable<UserViewModel> {
    return this.http.get<UserViewModel>('/api/user/' + id);
  }

  getUserByIdAssignProject(id: string): Observable<UserViewModel[]> {
    return this.http.get<UserViewModel[]>('/api/user/project/' + id);
  }

  public isAdmin():boolean{
    if(this.getAccount()!=null){
      if(this.getAccount().role == "ADMIN")return true;
      else return false
    }else return false
  }

  public isPM():boolean{
    if(this.getAccount()!=null){
      if(this.getAccount().role == "PROJECT_MANAGER")return true;
      else return false
    }else return false
  }

  public isDevOrTester():boolean{
    if(this.getAccount()!=null){
      if(this.getAccount().role == "DEVELOPER" || this.getAccount().role == "TESTER")return true;
      else return false
    }else return false
  }
}
