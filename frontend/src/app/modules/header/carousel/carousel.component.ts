import {Component, TemplateRef} from "@angular/core";
import {Project} from "../../project/model/project";
import {BsModalRef, BsModalService} from "ngx-bootstrap";

@Component({
  selector: 'carouselBack',
  templateUrl: "./carousel.html",
})
export class CarouselComponent{



  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService){}

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

}
