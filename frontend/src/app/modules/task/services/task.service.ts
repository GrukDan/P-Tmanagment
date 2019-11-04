import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Task} from "../model/task";


@Injectable()
// Data service
export class TaskService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for Task data
  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>('/api/ba');
  }

  saveTask(task: Task): Observable<Task> {
    return this.http.post<Task>('/api/ba', Task);
  }

  deleteTask(TaskId: string): Observable<void> {
    return this.http.delete<void>('/api/ba/' + TaskId);
  }

  getTaskById(id: string): Observable<Task> {
    return this.http.get<Task>('/api/ba/' + id);
  }

}
