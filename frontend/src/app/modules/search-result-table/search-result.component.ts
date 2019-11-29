import {Component, OnInit, TemplateRef} from "@angular/core";
import {Task} from "../task/model/task";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {TaskService} from "../task/services/task.service";
import {ActivatedRoute} from "@angular/router";
import {TaskViewModel} from "../task/model/taskViewModel";

@Component({
  selector: 'search-result',
  templateUrl: './search-result.html',
  styleUrls: ['./style.css']
})
export class SearchResultComponent {

  public searchString:string;
  public tasks :Task[] = [];
  private subscriptions: Subscription[] = [];

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private taskService:TaskService) {
  }

  ngOnInit(): void {
    this.searchString = this.activateRoute.snapshot.params['search'];
    this.loadTasks( this.searchString);
  }


  private loadTasks(search): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.taskService.getTasksByName(search).subscribe(tasks => {
      // Parse json response into local array
      this.tasks = tasks as Task[];
      // Check data in console
      console.log(this.tasks);// don't use console.log in angular :)
      this.loadingService.hide();
    }));
  }


  sortByName():void{
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.taskService.getTasksByNameSortByName(this.searchString).subscribe(tasks => {
      // Parse json response into local array
      this.tasks = tasks as Task[];
      // Check data in console
      this.loadingService.hide();
    }));
  }
}
