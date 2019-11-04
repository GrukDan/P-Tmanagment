import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../model/project";

@Injectable()
// Data service
export class ProjectService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for Project data
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/ba');
  }

  saveProject(project: Project): Observable<Project> {
    return this.http.post<Project>('/api/ba', Project);
  }

  deleteProject(ProjectId: string): Observable<void> {
    return this.http.delete<void>('/api/ba/' + ProjectId);
  }

  getProjectById(id: string): Observable<Project> {
    return this.http.get<Project>('/api/ba/' + id);
  }

}
