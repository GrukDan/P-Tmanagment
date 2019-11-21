import {Component, OnInit, TemplateRef} from "@angular/core";
import {Project} from "../model/project";
import {Task} from "../../task/model/task";
import {User} from "../../user/model/user";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {UserService} from "../../user/services/user.service";
import {ProjectService} from "../services/project.service";
import {TaskService} from "../../task/services/task.service";
import {ActivatedRoute} from "@angular/router";
import {ProjectViewModel} from "../model/projectViewModel";


@Component({
  selector: 'project',
  templateUrl: './project.component.html',
  styleUrls: ['./style.css']
})
export class ProjectComponent implements OnInit{

  public editMode:boolean = false;
  public projectViewModel: ProjectViewModel = new ProjectViewModel();

  private subscriptions: Subscription[] = [];
  customClass  = 'customClass';

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private projectService:ProjectService,) {
  }

  ngOnInit(): void {
    const id = this.activateRoute.snapshot.params['id'];
    this.loadProject(id)
  }

  private loadProject(id): void {
    this.loadingService.show();
    // Get data from BillingAccountService
    this.subscriptions.push(this.projectService.getProjectViewModelById(id).subscribe(projectViewModel => {
      // Parse json response into local array
      this.projectViewModel = projectViewModel;
      // Check data in console
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
    this.editMode= !this.editMode;
  }

  public refreshProject(): void{
  }

public showTask(taskId){
    location.href="task/"+taskId;
}

}
