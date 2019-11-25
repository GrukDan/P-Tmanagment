import {Component, TemplateRef} from "@angular/core";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../../user/services/user.service";
import {User} from "../../user/model/user";
import {UserViewModel} from "../../user/model/userViewModel";

@Component({
  selector: 'carouselBack',
  templateUrl: "./carousel.html",
})
export class CarouselComponent{

  public  userViewModel:UserViewModel = new UserViewModel();
  public account:User = new User();
  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService,
              private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,){}

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
                                                      // we keep the modal reference and pass the template local name to the modalService.
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public authorization():boolean{
    console.log(this.account);
    this.userViewModel = this.userService.authorization(this.account);
    //console.log(this.userViewModel);
    console.log(this.userService.account.name);
    return this.userViewModel?true:false;
  }
}
