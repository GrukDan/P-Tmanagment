import {Component, TemplateRef} from "@angular/core";
import {Project} from "../../project/model/project";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Task} from "../../task/model/task";
import {User} from "../../user/model/user";
import {UserService} from "../../user/services/user.service";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {Subscription} from "rxjs";


@Component({
  selector: 'appHead',
  templateUrl: "./appHead.html",
  styleUrls: ['./style.css']
})
export class HeadComponent{

  public project:Project = new Project();
  public task:Task = new Task();
  public user:User = new User();
  public modalRef: BsModalRef;

  private subscriptions: Subscription[] = [];

  constructor(private modalService: BsModalService,
              private loadingService: Ng4LoadingSpinnerService,
              private userService:UserService){}

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public addUser(): void {
    this.loadingService.show();
    console.log(this.user);
    this.subscriptions.push(this.userService.saveUser(this.user).subscribe(() => {
      this._closeModal();
      this.loadingService.hide();
    }));
  }
}
