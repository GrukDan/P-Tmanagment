import {Component, OnInit, TemplateRef} from "@angular/core";
import {Project} from "../../project/model/project";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Task} from "../../task/model/task";
import {User} from "../../user/model/user";
import {UserService} from "../../user/services/user.service";
import {ProjectService} from "../../project/services/project.service";
import {TaskService} from "../../task/services/task.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {Validators, FormBuilder, FormGroup, FormControl} from '@angular/forms';
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'appHead',
  templateUrl: "./appHead.html",
  styleUrls: ['./style.css']
})
export class HeadComponent implements OnInit {

  public project: Project = new Project();
  public task: Task = new Task();
  public user: User = new User();

  public projects: Project[] = [];
  public users: User[] = [];

  public flag: boolean = false;
  public modalRef: BsModalRef;
  public taskForm: FormGroup;
  public role: string;
  public priority: string;
  public addFlag: boolean = false;  //флаг на проверку введенных данных при добавлении

  public searchStr:string;
  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,
              private projectService: ProjectService,
              private taskService: TaskService) {
  }

  ngOnInit() {
    this.loadProjects();
    this.loadUsers();
  }

  private loadProjects(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.projectService.getProjects().subscribe(projects => {
      // Parse json response into local array
      this.projects = projects as Project[];
      // Check data in console
      console.log(this.projects);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  private loadUsers(): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.userService.getUsers().subscribe(users => {
      // Parse json response into local array
      this.users = users as User[];
      // Check data in console
      console.log(this.users);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public addUser(): void {
    this.loadingService.show();
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {
      this._closeModal();
      this.loadingService.hide();
    }));
  }

  public addProject(): void {
    this.loadingService.show();
    console.log(this.project);
    this.subscriptions.push(this.projectService.saveProject(this.project).subscribe(() => {
      this._closeModal();
      this.loadingService.hide();
    }));
  }

  public addTask(): void {
    this.task.status = "OPEN"
    this.task.dateOfCreation = Date.now().toString();
    this.task.update = Date.now().toString();
    this.task.taskCreator = this.users[0].idUser;
    this.loadingService.show();
    this.subscriptions.push(this.taskService.saveTask(this.task).subscribe(() => {
      this._closeModal();
      this.loadingService.hide();
    }));
  }

  public setRole() {
    if (this.role == "Admin") this.user.role = "ADMIN";
    if (this.role == "Project manager") this.user.role = "PROJECT_MANAGER";
    if (this.role == "Developer") this.user.role = "DEVELOPER";
    if (this.role == "Tester") this.user.role = "TESTER";
    console.log(this.user);
  }

  public setPriority() {
    if (this.priority == "Blocker") this.task.priority = "BLOCKER";
    if (this.priority == "Critical") this.task.priority = "CRITICAL";
    if (this.priority == "Major") this.task.priority = "MAJOR";
    if (this.priority == "Normal") this.task.priority = "NORMAL";
    if (this.priority == "Minor") this.task.priority = "MINOR";
  }

  public onChangeExecutor(val): void {
    this.task.executor = val.target.value;
  }

  public onChangeProject(val): void {
    let projectCode = this.projects.find(item=>item.idProject==val.target.value).projectCode + "-";
    this.task.taskCode = projectCode;
    this.task.idProject = val.target.value;
  }


  public search(){

    console.log(this.searchStr);
    location.href="search/"+ this.searchStr;
  }
}
