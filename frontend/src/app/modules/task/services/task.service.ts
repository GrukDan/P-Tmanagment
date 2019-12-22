import {Injectable} from "@angular/core";
import {HttpClient, HttpEvent, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../model/task";
import {TaskViewModel} from "../model/taskViewModel";
import {Comment} from "../model/comment";
import {CommentViewModel} from "../model/commentViewModel";
import {TaskPaginationModel} from "../model/taskPaginationModel";

@Injectable()
export class TaskService {

  constructor(private http: HttpClient) {
  }

  getTasksByName(taskName: string): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/name/' + taskName);
  }

  getTasksByNameSortByName(taskName: string): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/name' + taskName);
  }

  saveTask(task: Task): Observable<Task> {
    return this.http.post<Task>('/api/task', task);
  }

  saveTaskViewModel(taskViewModel: TaskViewModel): Observable<TaskViewModel> {
    return this.http.post<TaskViewModel>('/api/task/view/model/', taskViewModel);
  }

  deleteTask(taskId: string): Observable<void> {
    return this.http.delete<void>('/api/task/delete/' + taskId);
  }

  getTaskById(id: string): Observable<Task> {
    return this.http.get<Task>('/api/task/' + id);
  }

  getTaskViewModelById(id: number): Observable<TaskViewModel> {
    return this.http.get<TaskViewModel>('/api/task/view/model/' + id);
  }

  getTaskByIdProject(id: string): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/project/' + id);
  }

  getTaskByIdProjectSorted(idProject: string, parameter: string, direction: boolean): Observable<Task[]> {
    const asc:number = 1;
    const desc:number = 0;
    if(direction)
    return this.http.get<Task[]>('/api/tasks',
      {
        params: new HttpParams()
          .set("idProject", idProject)
          .set("parameter", parameter)
          .set("direction", asc.toString())
      });
    else
      return this.http.get<Task[]>('/api/tasks',
        {
          params: new HttpParams()
            .set("idProject", idProject)
            .set("parameter", parameter)
            .set("direction", desc.toString())
        });
  }

  getTaskByIdExecutor(id: string): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/executor/' + id);
  }

  saveComment(comment: Comment): Observable<Comment> {
    return this.http.post<Comment>("/api/comment", comment);
  }

  getCommentsByTaskId(size: number, idTask: string): Observable<CommentViewModel[]> {
    return this.http.get<CommentViewModel[]>("/api/comments", {params: new HttpParams().set("size", size.toString()).set("idTask", idTask)});
  }

  deleteCommentsByTaskId(idTask: string): Observable<void> {
    return this.http.delete<void>("/api/comments/" + idTask);
  }

  getTasksSort(parameter:string,page:number,size:number,direction:boolean,search:string=""):Observable<TaskPaginationModel>{
    return this.http.get<TaskPaginationModel>('/api/tasks/pagination',
      {params:new HttpParams()
          .set("parameter",parameter)
          .set("page",page.toString())
          .set("size",size.toString())
          .set("direction",direction.toString())
          .set("search",search)});
  }
}
