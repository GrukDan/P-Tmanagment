import {Component, TemplateRef} from "@angular/core";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../user/services/user.service";
import {User} from "../../user/model/user";
import {UserViewModel} from "../../user/model/userViewModel";

@Component({
  selector: 'carouselBack',
  templateUrl: "./carousel.html",
})
export class CarouselComponent{

  public  userViewModel:UserViewModel;
  public account:User = new User();
  public modalRef: BsModalRef;

  constructor(private modalService: BsModalService,
              private loadingService: Ng4LoadingSpinnerService,
              private activateRoute: ActivatedRoute,
              private userService: UserService,
              private router: Router){}

  public _openModal(template: TemplateRef<any>): void {
    this.modalRef = this.modalService.show(template);
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }


  public authorization():void{
    this.userService.authorization(this.account).subscribe(user => {
      this.userViewModel = user;

      if (this.userViewModel.name) {
        this._closeModal();
        this.router.navigate(['/account',this.userService.account.idUser]);
      }
    });
  }
}
