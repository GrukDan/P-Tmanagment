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
import {ActivatedRoute, Router} from "@angular/router";
import {UserViewModel} from "../../user/model/userViewModel";


@Component({
  selector: 'appHead',
  templateUrl: "./app-head.html",
  styleUrls: ['./style.css']
})
export class HeadComponent implements OnInit {

  public availablePriorities = ["Blocker", "Critical", "Major", "Normal", "Minor"];
  public availableRoles = ["Project manager", "Developer", "Tester"];

  public project: Project = new Project();
  public task: Task = new Task();
  public user: User = new User();

  public projects: Project[] = [];
  public userViewModels: UserViewModel[] = [];

  public modalRef: BsModalRef;
  public role: string;
  public addFlag: boolean = false;
  public addTaskFlag: boolean = false;
  public addUserFlag:boolean = true;
  public executorName:string="";

  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,
              private projectService: ProjectService,
              private taskService: TaskService,
              private router: Router) {
    this.addUserFlag = true;
  }

  ngOnInit() {
  }

  public projectNavigationClick(): void {
    this.loadProjects();
  }

  public loadProjects(): void {
    this.subscriptions.push(this.projectService.getProjects().subscribe(projects => {
      this.projects = projects as Project[];
    }));
  }

  private loadUsers(): void {
    this.subscriptions.push(this.userService.getUserByIdAssignProject(this.task.idProject).subscribe(users => {
      this.userViewModels = users as UserViewModel[];
    }));
  }

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  public addUser(role:string): void {
    this.setRole(role);
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(user => {
      if(user!=null){
        this.addUserFlag = true;
        this._closeModal();
      }
      else this.addUserFlag = false;
    }));
  }

  public addProject(): void {
    this.project.projectCreator = this.userService.getAccount().idUser;
    this.subscriptions.push(this.projectService.saveProject(this.project).subscribe(() => {
      this._closeModal();
    }));
  }

  public addTask(executor,priority): void {
    this.task.status = "OPEN"
    this.task.dateOfCreation = Date.now().toString();
    this.task.updated = Date.now().toString();
    this.task.taskCreator = this.userService.getAccount().idUser;
    if(executor!="") this.task.executor = executor;
    this.setPriority(priority)
    console.log(this.task);
    this.subscriptions.push(this.taskService.saveTask(this.task).subscribe(() => {
      this._closeModal();
    }));
  }

  public setRole(role: string): void {
    if (role == "Project manager") this.user.role = "PROJECT_MANAGER";
    if (role == "Developer") this.user.role = "DEVELOPER";
    if (role == "Tester") this.user.role = "TESTER";
  }

  public setPriority(priority: string): void {
    if (priority == "Blocker") this.task.priority = "BLOCKER";
    if (priority == "Critical") this.task.priority = "CRITICAL";
    if (priority == "Major") this.task.priority = "MAJOR";
    if (priority == "Normal") this.task.priority = "NORMAL";
    if (priority == "Minor") this.task.priority = "MINOR";
  }

  public onChangeExecutor(val): void {
    console.log(val);
    this.task.executor = val;
  }

  public onChangeProject(val): void {
    let projectCode = this.projects.find(item => item.idProject == val.target.value).projectCode + "-";
    this.task.taskCode = projectCode;
    this.task.idProject = val.target.value;
    this.loadUsers();
  }

  public search(target): void {
    this.router.navigate(['/search', target.value]);
    target.value="";
  }

  public logOut(): void {
    this.router.navigate(['']);
    this.userService.removeAccount();
  }

  public toTasks(){
    this.router.navigate(['/tasks']);
  }

  public toAccounts(){
    this.router.navigate(['/accounts']);

  }

}
