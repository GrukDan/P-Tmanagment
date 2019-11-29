import {Component, OnInit} from "@angular/core";
import {User} from "../model/user";
import {Project} from "../../project/model/project";
import {Task} from "../../task/model/task";
import {BsModalService} from "ngx-bootstrap";
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

  public account: UserViewModel = new UserViewModel;
  public assignProject: Project = new Project();
  public projects: Project[] = [];
  public tasks: Task[] = [];

  public editMode: boolean = false;
  public subscriptions: Subscription[] = [];

  constructor(private activateRoute: ActivatedRoute,
              private userServise: UserService,
              private loadingService: Ng4LoadingSpinnerService,
              private projectService: ProjectService,
              private taskService: TaskService,
              private router: Router) {
  }


  public edit(): void {

    if (this.editMode) {
      this.loadingService.show();
      this.subscriptions.push(this.userServise.saveUserViewModel(this.account).subscribe(() => {
        this.loadingService.hide();
      }));
    }else this.loadAllProjects();
    this.editMode = !this.editMode;
  }

  ngOnInit(): void {
    const id = this.activateRoute.snapshot.params['id'];
    this.loadUserViewModel(id);

  }

  private loadUserViewModel(idUser: string): void {
    this.loadingService.show();
    this.subscriptions.push(this.userServise.getUserById(idUser).subscribe(userViewModel => {
      this.account = userViewModel;
      if(userViewModel.assignProject)
      this.loadAssignProject(userViewModel.assignProject);
      this.loadTaskViewModels();
    }));
    this.loadingService.hide();
  };

  private loadAssignProject(idProject: string): void {
    this.subscriptions.push((this.projectService.getProjectById(idProject).subscribe(project => {
      this.assignProject = project;
    })))
  }


  private loadAllProjects():void{
    this.subscriptions.push((this.projectService.getProjects().subscribe(projects=>{
      this.projects = projects as Project[];
    })))
  }

  private loadTaskViewModels():void{
    this.subscriptions.push(this.taskService.getTaskByIdExecutor(this.account.idUser).subscribe(task=>{
      this.tasks = task as Task[];
      console.log(this.projects);
    }))
  }

  public assignProjectFocus():void{
    this.loadAllProjects();
  }

  public assignProjectBlur():void{
    this.loadAssignProject(this.account.assignProject);
  }

  public deleteAccount():void{
    this.subscriptions.push(this.userServise.deleteUser(this.account.idUser).subscribe(()=>{
      this.router.navigate(['/project', this.assignProject.idProject]);
    }));
  }
}
