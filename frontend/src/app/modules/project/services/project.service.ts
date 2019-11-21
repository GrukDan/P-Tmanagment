import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Project} from "../model/project";
import {ProjectViewModel} from "../model/projectViewModel";

@Injectable()
// Data service
export class ProjectService { //todo create interface

  constructor(private http: HttpClient) {
  }

  // Ajax request for Project data
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>('/api/projects');
  }

  saveProject(project: Project): Observable<Project> {
    return this.http.post<Project>('/api/project', project);
  }

  deleteProject(projectId: string): Observable<void> {
    return this.http.delete<void>('/api/project/' + projectId);
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
