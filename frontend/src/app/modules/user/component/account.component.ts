import {Component, OnInit, ViewChild} from "@angular/core";
import {User} from "../model/user";
import {Project} from "../../project/model/project";
import {Task} from "../../task/model/task";
import {BsModalService, TabsetComponent} from "ngx-bootstrap";
import {UserViewModel} from "../model/userViewModel";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {ProjectService} from "../../project/services/project.service";
import {TaskService} from "../../task/services/task.service";


@Component({
  selector: 'account',
  templateUrl: './account.html',
  styleUrls: ['./style.css']
})
export class AccountComponent implements OnInit {
  public availableRoles = ["Project manager", "Developer", "Tester"];

  private idUser: string;
  public account: UserViewModel = new UserViewModel;
  public assignProject: Project = null;
  public projects: Project[] = [];
  public tasks: Task[] = [];

  public editMode: boolean = false;
  public subscriptions: Subscription[] = [];

  constructor(private activateRoute: ActivatedRoute,
              private userService: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private projectService: ProjectService,
              private taskService: TaskService,
              private router: Router) {
    this.activateRoute.params.subscribe(
      params => {
        this.idUser = params['id'];
        this.loadUserViewModel();
      }
    );
  }

  public edit(): void {
    if (this.editMode) {
      this.loadingService.show();
      this.changeRole();
      this.subscriptions.push(this.userService.saveUserViewModel(this.account).subscribe(() => {
        this.loadingService.hide();
        this.loadUserViewModel();
      }));
    } else this.loadAllProjects();
    this.editMode = !this.editMode;
    this.setRole();
  }

  ngOnInit(): void {}

  private loadUserViewModel(): void {
    this.loadingService.show();

    this.subscriptions.push(this.userService.getUserById(this.idUser).subscribe(userViewModel => {
      this.account = userViewModel;
      this.setRole();
      if (userViewModel.assignProject!=null) {
        this.loadAssignProject(userViewModel.assignProject);
        this.loadTaskViewModels();
      }
    }));
    this.loadingService.hide();
  };

  private setRole(): void {
    if (this.account.role == "ADMIN") this.account.role = "Admin";
    else if (this.account.role == "PROJECT_MANAGER") this.account.role = "Project manager";
    else if (this.account.role == "TESTER") this.account.role = "Tester";
    else if(this.account.role == "DEVELOPER") this.account.role = "Developer";
  }

  private changeRole(): void {
    if (this.account.role == "Admin") this.account.role = "ADMIN";
    else if (this.account.role == "Project manager") this.account.role = "PROJECT_MANAGER";
    else if (this.account.role == "Tester") this.account.role = "TESTER";
    else if (this.account.role == "Developer") this.account.role = "DEVELOPER";
  }

  private loadAssignProject(idProject: string): void {
    if(idProject!=null)
    this.subscriptions.push((this.projectService.getProjectById(idProject).subscribe(project => {
      this.assignProject = project;
    })))
  }


  private loadAllProjects(): void {
    this.subscriptions.push((this.projectService.getProjects().subscribe(projects => {
      this.projects = projects as Project[];
    })))
  }

  private loadTaskViewModels(): void {
    this.subscriptions.push(this.taskService.getTaskByIdExecutor(this.account.idUser).subscribe(task => {
      this.tasks = task as Task[];
      this.tasks.forEach(task => {
        if (task.status == "OPEN") task.status = "Open";
        else if (task.status == "READY_FOR_TEST") task.status = "Ready for test";
        else if (task.status == "IN_PROGRESS") task.status = "In progress";
        else if (task.status == "CLOSED") task.status = "Closed";

        if (task.priority == "BLOCKER") task.priority = "Blocker";
        else if (task.priority == "CRITICAL") task.priority = "Critical";
        else if (task.priority == "MAJOR") task.priority = "Major";
        else if (task.priority == "NORMAL") task.priority = "Normal";
        else if (task.priority == "MINOR") task.priority = "Minor";
      })
    }))
  }

  public assignProjectBlur(): void {
    this.loadAssignProject(this.account.assignProject);
  }

  public deleteAccount(): void {
    this.subscriptions.push(this.userService.deleteUser(this.account.idUser).subscribe(() => {
      this.router.navigate(['']);
    }));
  }

  public notAdminAccount(): boolean {
    if (this.account.role !="Admin") return true;
  }
}
