import {Component, OnInit, TemplateRef} from "@angular/core";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";
import {ProjectService} from "../services/project.service";
import {ActivatedRoute, Params} from "@angular/router";
import {ProjectViewModel} from "../model/projectViewModel";
import {Task} from "../../task/model/task";
import {TaskService} from "../../task/services/task.service";


@Component({
  selector: 'project',
  templateUrl: './project.component.html',
  styleUrls: ['./style.css']
})
export class ProjectComponent implements OnInit {

  public editMode: boolean = false;
  public projectViewModel: ProjectViewModel = new ProjectViewModel();
  public tasks: Task[] = [];
  public id: string;

  private subscriptions: Subscription[] = [];

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private projectService: ProjectService,
              private taskService: TaskService) {


    // подписываемся на параметры
    this.activateRoute.params.subscribe(
      params => {
        let id = +params['id'];
        this.id = params['id'];
        this.loadProject(this.id);
        this.loadTasks(this.id);
      }
    );

  }

  ngOnInit(): void {

  }

  private getProject(): void {
    const id = +this.activateRoute.snapshot.paramMap.get('id');
    this.loadProject(id);
    this.loadTasks(id);
  }


  private loadTasks(id): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.getTaskByIdProject(id).subscribe(tasks => {
      this.tasks = tasks as Task[];
      this.loadingService.hide();
    }));
  }

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


  public sortByPriority(): void {
    this.subscriptions.push(this.taskService.getTaskByIdProjectSortedByPrioruty(this.id, 3).subscribe(tasks => {
      this.tasks = tasks as Task[];
    }));
  }

}
