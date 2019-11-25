import {Component, OnInit, TemplateRef} from "@angular/core";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {ProjectService} from "../services/project.service";
import {ActivatedRoute, Params} from "@angular/router";
import {ProjectViewModel} from "../model/projectViewModel";
import {Location} from "@angular/common";


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
              private projectService:ProjectService,
              private location:Location) {


    // подписываемся на параметры
    this.activateRoute.params.subscribe(
      params => {
        let id = +params['id'];
        this.loadProject(params['id']);
      }
    );

    //this.getProject();
  }

  ngOnInit(): void {
//this.getProject();

  }

  private getProject():void{
    const id= +this.activateRoute.snapshot.paramMap.get('id');
    this.loadProject(id);
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


}
