import {Component, TemplateRef} from "@angular/core";
import {Project} from "../model/project";
import {Task} from "../../task/model/task";
import {User} from "../../user/model/user";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {ProjectService} from "../services/project.service";

@Component({
  selector: 'project',
  templateUrl: './project.component.html',
  styleUrls: ['./style.css']
})
export class ProjectComponent{

  public editMode = false;

  public project: Project = new Project();
  public editableProject: Project = new Project();
  public projectAuthor:User = new User();

  public tasks :Task[];


  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  constructor(
    private modalService: BsModalService) {
    this.project.projectName="Имя проекта";
    this.project.projectCode="Код проекта";
    this.project.projectCreator="Имя проекта";
    this.project.readinessDegree=99;
    this.project.dateOfCompletion="Имя проекта";
    this.project.descriptionOfProject = "Метод ngOnInit() применяется для какой-то комплексной инициализации компонента. Здесь можно выполнять загрузку данных с сервера или из других источников данных.";
    this.projectAuthor.name = "Author";


  }

  public _openModal(template: TemplateRef<any>, project: Project): void {

    if (project) {
      this.editMode = true;
      this.editableProject = Project.cloneBase(project);
    } else {
      this.refreshProject();
      this.editMode = false;
    }
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }
  public _closeModal(): void {
    this.modalRef.hide();
  }

  public refreshProject(): void{

  }

}
