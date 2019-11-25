import {Component} from "@angular/core";
import {User} from "../model/user";
import {Project} from "../../project/model/project";
import {Task} from "../../task/model/task";
import {BsModalService} from "ngx-bootstrap";
import {UserViewModel} from "../model/userViewModel";

@Component({
  selector: 'account',
  templateUrl: './account.html',
  styleUrls: ['./style.css']
})
export class AccountComponent{

  public user:UserViewModel = new UserViewModel;
  public projects: Project[] = [];
  public tasks :Task[] = [];

  public editMode:boolean = false;

  constructor() {
      }

  public edit(): void {
    this.editMode= !this.editMode;
  }


}
