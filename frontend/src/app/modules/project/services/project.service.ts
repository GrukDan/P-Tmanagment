import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../model/project";
import {ProjectViewModel} from "../model/projectViewModel";

@Injectable()
// Data service
export class ProjectService { //todo create interface

  constructor(private http: HttpClient) {
  }

  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects');
  }

  saveProject(project: Project): Observable<Project> {
    return this.http.post<Project>('/api/project', project);
  }

  deleteProject(idProject: string): Observable<void> {
    return this.http.delete<void>('/api/project',{params:new HttpParams().set("idProject",idProject)});
  }

  getProjectById(id: string): Observable<Project> {
    return this.http.get<Project>('/api/project/' + id);
  }

  getProjectViewModelById(id: string): Observable<ProjectViewModel> {
    return this.http.get<ProjectViewModel>('/api/project/view/model/' + id);
  }

  saveProjectViewModel(projectViewModel: ProjectViewModel): Observable<Project> {
    return this.http.post<ProjectViewModel>('/api/project/view/model', projectViewModel);
  }
}
