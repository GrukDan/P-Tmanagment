import {Component, OnInit} from "@angular/core";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {PageChangedEvent} from "ngx-bootstrap";
import {TaskPaginationModel} from "../task/model/taskPaginationModel";
import {TaskViewModel} from "../task/model/taskViewModel";
import {TaskService} from "../task/services/task.service";

@Component({
  selector: 'tasks-table',
  templateUrl: './task-table.html',
  styleUrls: ['./style.css']
})
export class TasksTableComponent implements OnInit {
  public taskPaginationModel: TaskPaginationModel;
  public tasks: TaskViewModel[] = [];
  public subscriptions: Subscription[] = [];
  private querySubscription: Subscription;

  public parameters: string[] = ["taskName", "priority", "status","dateOfCreation","dueDate","updated"];
  public pagesCount: number;
  public direction: boolean = true;
  public parameter: string;
  public page: number;
  public size: number;

  public constructor(private taskService: TaskService,
                     private route: ActivatedRoute
  ) {
    this.querySubscription = route.queryParams.subscribe(()=> {
        this.parameter = "taskName";
        this.page = 0;
        this.size = 5;
        this.pagesCount = 11;
        this.loadTasks(this.page);
      });
  }

  ngOnInit(): void {
  }

  private loadTasks(page: number): void {
    this.subscriptions.push(this.taskService.getTasksSort(this.parameter, page, this.size, this.direction).subscribe(taskPaginationModel => {
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
