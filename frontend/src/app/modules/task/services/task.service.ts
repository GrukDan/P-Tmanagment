import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../model/task";
import {TaskViewModel} from "../model/taskViewModel";


@Injectable()
// Data service
export class TaskService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for Task data
  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks');
  }

  getTasksByName(taskName:string): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/name/' + taskName);
  }

  getTasksByNameSortByName(taskName:string): Observable<Task[]> {
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

  getTaskByIdProjectSortedByPrioruty(id: string,count:number): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/project/name/sort/priority' ,{
      params: new HttpParams().set('projectId',id).set('count',count.toString())
  });
  }

  getTaskByIdExecutor(id: string): Observable<Task[]> {
    return this.http.get<Task[]>('/api/tasks/executor/' + id);
  }

}
