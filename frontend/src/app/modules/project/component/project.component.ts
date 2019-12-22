import {Component, OnInit, TemplateRef} from "@angular/core";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {ProjectService} from "../services/project.service";
import {ActivatedRoute, Params, Router} from "@angular/router";
import {ProjectViewModel} from "../model/projectViewModel";
import {Task} from "../../task/model/task";
import {TaskService} from "../../task/services/task.service";
import {UserService} from "../../user/services/user.service";


@Component({
  selector: 'project',
  templateUrl: './project.component.html',
  styleUrls: ['./style.css']
})
export class ProjectComponent implements OnInit {

  public sortParameter: string[] = ["taskName", "priority", "status", "dateOfCreation", "dueDate"];
  public editMode: boolean = false;
  public projectViewModel: ProjectViewModel = new ProjectViewModel();
  public tasks: Task[] = [];
  public id: string;
  private subscriptions: Subscription[] = [];
  public direction: boolean = false;

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private projectService: ProjectService,
              private taskService: TaskService,
              private userService:UserService,
              private router:Router) {

    this.activateRoute.params.subscribe(
      params => {
        this.id = params['id'];
        this.loadProject(this.id);
        this.loadSortedTask(this.sortParameter[0]);
      }
    );
  }

  ngOnInit(): void {  }

  private loadProject(id): void {
    this.loadingService.show();
    this.subscriptions.push(this.projectService.getProjectViewModelById(id).subscribe(projectViewModel => {
      this.projectViewModel = projectViewModel;
      this.loadingService.hide();
    }));
  }

  public edit(): void {
    if (this.editMode) {
      this.loadingService.show();
      this.subscriptions.push(this.projectService.saveProjectViewModel(this.projectViewModel).subscribe(() => {
        this.loadingService.hide();
      }));
    }
    this.editMode = !this.editMode;
  }

  public refreshProject(): void {
  }

  public loadSortedTask(parameter: string): void {
    this.direction = !this.direction;
    this.subscriptions.push(this.taskService.getTaskByIdProjectSorted(this.id, parameter, this.direction).subscribe(tasks => {
      this.tasks = tasks as Task[];
      this.tasks.forEach(task=> {
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
    }));
  }

  public deleteProject():void{
    this.subscriptions.push(this.projectService.deleteProject(this.projectViewModel.idProject).subscribe(val=>{
      this.router.navigate(['']);
    }));
  }
}
