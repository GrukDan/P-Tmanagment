import {Component, OnInit} from "@angular/core";
import {Task} from "../model/task";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../user/services/user.service";
import {ProjectService} from "../../project/services/project.service";
import {TaskService} from "../services/task.service";
import {Project} from "../../project/model/project";
import {User} from "../../user/model/user";
import {Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskViewModel} from "../model/taskViewModel";

@Component({
  selector: 'task',
  templateUrl: './task.html',
  styleUrls: ['./style.css']
})
export class TaskComponent implements OnInit {

  public taskViewModel: TaskViewModel = new TaskViewModel;
  public editMode: boolean = false;
  public priority: string;
  public status: string;
  public idProject: string;
  private subscriptions: Subscription[] = [];

  public edit(): void {
    if (this.editMode) {
      this.taskViewModel.updated = Date.now().toString();
      this.loadingService.show();
      this.subscriptions.push(this.taskService.saveTaskViewModel(this.taskViewModel).subscribe(() => {
        this.loadingService.hide();
      }));
    }
    this.editMode = !this.editMode;
  }

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,
              private projectService: ProjectService,
              private taskService: TaskService,
              private router:Router) {

  }

  ngOnInit(): void {
    const id = this.activateRoute.snapshot.params['id'];
    this.loadTask(id);

    this.priority = this.taskViewModel.priority;
    this.status = this.taskViewModel.status;
    this.idProject = this.taskViewModel.idProject;

    if (this.taskViewModel.status == "OPEN") this.taskViewModel.status = "Open";
    if (this.taskViewModel.status == "IN_PROGRESS") this.taskViewModel.status = "In progress";
    if (this.taskViewModel.status == "READY_FOR_TEST") this.taskViewModel.status = "Ready for test";
    if (this.taskViewModel.status == "CLOSED") this.taskViewModel.status = "Closed";

    if (this.taskViewModel.priority == "BLOCKER") this.taskViewModel.priority = "BLOCKER";
    if (this.taskViewModel.priority == "CRITICAL") this.taskViewModel.priority = "Critical";
    if (this.taskViewModel.priority == "MAJOR") this.taskViewModel.priority = "Major";
    if (this.taskViewModel.priority == "NORMAL") this.taskViewModel.priority = "Normal";
    if (this.taskViewModel.priority == "MINOR") this.taskViewModel.priority = "Minor";
  }

  private loadTask(id): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.getTaskViewModelById(id).subscribe(taskViewModel => {
      this.taskViewModel = taskViewModel;
      console.log(this.taskViewModel);
      this.loadingService.hide();
    }));
  }

  public setPriority() {
    if (this.priority == "Blocker") this.taskViewModel.priority = "BLOCKER";
    if (this.priority == "Critical") this.taskViewModel.priority = "CRITICAL";
    if (this.priority == "Major") this.taskViewModel.priority = "MAJOR";
    if (this.priority == "Normal") this.taskViewModel.priority = "NORMAL";
    if (this.priority == "Minor") this.taskViewModel.priority = "MINOR";
  }

  public setStatus() {
    if (this.status == "Open") this.taskViewModel.status = "OPEN";
    if (this.status == "In progress") this.taskViewModel.status = "IN_PROGRESS";
    if (this.status == "Ready for test") this.taskViewModel.status = "READY_FOR_TEST";
    if (this.status == "Closed") this.taskViewModel.status = "CLOSED";
  }

  public onChangeExecutor(val): void {
    this.taskViewModel.executorId = val.target.value;
  }


  public deleteTask() {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.taskService.deleteTask(this.taskViewModel.idTask).subscribe(taskViewModel => {
      this.loadingService.hide();
      console.log(this.idProject);
      this.router.navigate(['/project', this.idProject]);
    }));

  }
}
