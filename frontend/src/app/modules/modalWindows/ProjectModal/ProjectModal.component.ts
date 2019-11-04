import {Component} from "@angular/core";
import {Project} from "../../project/model/project";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'ProjectModal',
  templateUrl: "./ProjectModal.html",
})
export class ProjectModal{

  public project:Project = new Project();


  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  public _closeModal(): void {
    this.modalRef.hide();
  }
}
