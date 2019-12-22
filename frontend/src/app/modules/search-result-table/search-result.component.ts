import {Component, OnInit} from "@angular/core";
import { PageChangedEvent} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {TaskService} from "../task/services/task.service";
import {ActivatedRoute} from "@angular/router";
import {TaskViewModel} from "../task/model/taskViewModel";
import {TaskPaginationModel} from "../task/model/taskPaginationModel";

@Component({
  selector: 'search-result',
  templateUrl: './search-result.html',
  styleUrls: ['./style.css']
})
export class SearchResultComponent implements OnInit{

  public searchString:string;
  public taskPaginationModel:TaskPaginationModel;
  public tasks: TaskViewModel[] = [];
  private subscriptions: Subscription[] = [];

  public parameters: string[] = ["taskName", "priority", "status","dateOfCreation","dueDate","updated"];
  public pagesCount: number;
  public direction: boolean = true;
  public parameter: string;
  public page: number;
  public size: number;

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private taskService:TaskService) {

    this.activateRoute.params.subscribe(
      params => {
        this.searchString = this.activateRoute.snapshot.params['search'];
        this.parameter = "taskName";
        this.page = 0;
        this.size = 5;
        this.pagesCount = 11;
        this.loadTasks(this.page);
      }
    );
  }

  ngOnInit(): void {}

  private loadTasks(page: number): void {
    this.subscriptions.push(this.taskService.getTasksSort(this.parameter, page, this.size, this.direction,this.searchString).subscribe(taskPaginationModel => {
      this.taskPaginationModel = taskPaginationModel;
      this.tasks = this.taskPaginationModel.tasksOnPage;
      this.pagesCount = (this.taskPaginationModel.pagesCount/5) * 10;
      this.changePriorityAndStatus();
    }));
  }

  public sort(parameter: string): void {
    this.parameter = parameter;
    this.direction = !this.direction;
    this.loadTasks(this.page);
  }

  pageChanged(event: PageChangedEvent) {
    this.page = event.page - 1;
    this.loadTasks(this.page);
  }

  private changePriorityAndStatus():void{
    this.tasks.forEach(task=>{
      if(task.priority == "BLOCKER") task.priority = "Blocker";
      else if (task.priority == "CRITICAL") task.priority = "Critical";
      else if (task.priority == "MAJOR") task.priority = "Major";
      else if (task.priority == "MINOR") task.priority = "Minor";
      else task.priority = "Normal"

      if(task.status =="OPEN") task.status = "Open";
      else if(task.status =="IN_PROGRESS") task.status = "In progress";
      else if(task.status =="READY_FOR_TEST") task.status = "Ready for test";
      else task.status = "Closed";
    })
  }
}
