import {Component} from "@angular/core";
import {User} from "../model/user";
import {Project} from "../../project/model/project";
import {Task} from "../../task/model/task";
import {BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'account',
  templateUrl: './account.html',
  styleUrls: ['./style.css']
})
export class AccountComponent{

  public user:User = new User;
  public projects: Project[] = [];
  public tasks :Task[] = [];

  public editMode:boolean = false;

  constructor() {
    this.user.name ="Tom";
    this.user.surname = "Hanks";
    this.user.email="tom@mail.ru";
    this.user.role="tester";
    this.user.login="sdfs2";
    this.user.password="sdsd2232";
      }

  public edit(): void {
    this.editMode= !this.editMode;
  }


}
