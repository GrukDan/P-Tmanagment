import {Component, OnInit} from "@angular/core";
import {Task} from "../model/task";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../user/services/user.service";
import {ProjectService} from "../../project/services/project.service";
import {TaskService} from "../services/task.service";
import {Observable, Subscription} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {TaskViewModel} from "../model/taskViewModel";
import {Comment} from "../model/comment";
import {CommentViewModel} from "../model/commentViewModel";
import {tap} from "rxjs/operators";

@Component({
  selector: 'task',
  templateUrl: './task.html',
  styleUrls: ['./style.css']
})
export class TaskComponent implements OnInit {

  public availableStatuses = ["Open", "In progress", "Ready for test", "Closed"];
  public availablePriorities = ["Blocker", "Critical", "Major", "Normal","Minor"];

  public taskViewModel: TaskViewModel = new TaskViewModel;
  public editMode: boolean = false;
  public idProject: string;
  public commentsFlag: boolean;
  public comment: Comment = new Comment();
  public comments: CommentViewModel[] = [];
  public startCommentsSize:number = 3;
  private subscriptions: Subscription[] = [];

  public edit(): void {
    if (this.editMode) {
      this.taskViewModel.updated = Date.now().toString();
      this.loadingService.show();

      if (this.taskViewModel.status == "Open") this.taskViewModel.status = "OPEN";
      if (this.taskViewModel.status == "In progress") this.taskViewModel.status = "IN_PROGRESS";
      if (this.taskViewModel.status == "Ready for test") this.taskViewModel.status = "READY_FOR_TEST";
      if (this.taskViewModel.status == "Closed") this.taskViewModel.status = "CLOSED";

      if (this.taskViewModel.priority== "Blocker") this.taskViewModel.priority = "BLOCKER";
      if (this.taskViewModel.priority == "Critical") this.taskViewModel.priority = "CRITICAL";
      if (this.taskViewModel.priority == "Major") this.taskViewModel.priority = "MAJOR";
      if (this.taskViewModel.priority == "Normal") this.taskViewModel.priority = "NORMAL";
      if (this.taskViewModel.priority == "Minor") this.taskViewModel.priority = "MINOR";
      this.subscriptions.push(this.taskService.saveTaskViewModel(this.taskViewModel).subscribe(() => {
        this.loadingService.hide();
        this.subscriptions.push(this.loadTask(this.taskViewModel.idTask).subscribe());
      }));
    }
    this.editMode = !this.editMode;
  }

  constructor(private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,
              private projectService: ProjectService,
              private taskService: TaskService,
              private router: Router) {

    this.commentsFlag = true;
  }

  ngOnInit(): void {
    const id = this.activateRoute.snapshot.params['id'];
    this.subscriptions.push(this.loadTask(id).subscribe(
      () => {
        this.idProject = this.taskViewModel.idProject;
      }
    ));
    this.loadComments(this.startCommentsSize, id);
  }

  private loadTask(id): Observable<TaskViewModel> {
    return this.taskService.getTaskViewModelById(id).pipe(
      tap((taskViewModel) => {
        this.taskViewModel = taskViewModel;

        if (this.taskViewModel.status == "OPEN") this.taskViewModel.status = "Open";
        if (this.taskViewModel.status == "IN_PROGRESS") this.taskViewModel.status = "In progress";
        if (this.taskViewModel.status == "READY_FOR_TEST") this.taskViewModel.status = "Ready for test";
        if (this.taskViewModel.status == "CLOSED") this.taskViewModel.status = "Closed";

        if (this.taskViewModel.priority == "BLOCKER") this.taskViewModel.priority = "Blocker";
        if (this.taskViewModel.priority == "CRITICAL") this.taskViewModel.priority = "Critical";
        if (this.taskViewModel.priority == "MAJOR") this.taskViewModel.priority = "Major";
        if (this.taskViewModel.priority == "NORMAL") this.taskViewModel.priority = "Normal";
        if (this.taskViewModel.priority == "MINOR") this.taskViewModel.priority = "Minor";
      }),
    )
  }

  private loadComments(size, idTask): void {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.getCommentsByTaskId(size, idTask).subscribe(comment => {
      this.comments = comment;
      this.loadingService.hide();
    }))
  }

  public setPriority(value: string) {
    this.taskViewModel.priority = value;
  }

  public setStatus(value: string) {
    this.taskViewModel.status = value;
  }

  public onChangeExecutor(val): void {
    this.taskViewModel.executorId = val.target.value;
  }

  public deleteTask() {
    this.loadingService.show();
    this.subscriptions.push(this.taskService.deleteCommentsByTaskId(this.taskViewModel.idTask).subscribe(() => {
      this.subscriptions.push(this.taskService.deleteTask(this.taskViewModel.idTask).subscribe(taskViewModel => {
        this.loadingService.hide();
        this.router.navigate(['/project', this.idProject]);
      }))
    }));
  }

  public saveComment(): void {
    this.comment.dateOfCreation = Date.now().toString();
    this.comment.idTask = this.taskViewModel.idTask;
    this.comment.idUser = this.userService.getAccount().idUser;
    this.subscriptions.push(this.taskService.saveComment(this.comment).subscribe(() => {
      this.loadComments(this.comments.length + 1, this.taskViewModel.idTask);
    }));
    this.comment.comment = "";
  }

  public showMoreComments(): void {
    this.loadComments(this.comments.length * 2, this.taskViewModel.idTask);
  }

}
