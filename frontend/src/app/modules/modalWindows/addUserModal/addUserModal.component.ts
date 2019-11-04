import {Component, OnInit, TemplateRef} from '@angular/core';
import {User} from "../../user/model/user";
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {Subscription} from "rxjs/internal/Subscription";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {UserService} from "../../user/services/user.service";

@Component({
  selector: 'appAddUserModal',
  templateUrl: "./addUserModal.html",
})

export class UserModal implements OnInit {

  public editMode = false;

  public editableUser: User = new User();
  public modalRef: BsModalRef; //we need a variable to keep a reference of our modal. This is going to be used to close the modal.

  private subscriptions: Subscription[] = [];


  // Dependency injection for BillingAccountService into Billing
  // constructor(              private userService: UserService,
  //   private loadingService: Ng4LoadingSpinnerService,
  //             private modalService: BsModalService) { //to show the modal, we also need the ngx-bootstrap service
  // }

  // Calls on component init
  ngOnInit() {
    // this.loadBillingAccounts();
  }

  public _closeModal(): void {
    this.modalRef.hide();
  }

  // public _openModal(template: TemplateRef<any>, user: User): void {
  //
  //   if (user) {
  //     this.editMode = true;
  //     this.editableUser = User.cloneBase(user);
  //   } else {
  //     this.refreshBa();
  //     this.editMode = false;
  //   }
  //
  //   this.modalRef = this.modalService.show(template); // and when the user clicks on the button to open the popup
  //                                                     // we keep the modal reference and pass the template local name to the modalService.
  // }

  // public _addUser(): void {
  //   this.loadingService.show();
  //   this.subscriptions.push(this.userService.saveUser(this.editableUser).subscribe(() => {
  //     this._updateUsers();
  //     this.refreshUsers();
  //     this._closeModal();
  //     this.loadingService.hide();
  //
  //   }));
  // }
  //
  // public _updateUsers(): void {
  //   // this.loadBillingAccounts();
  // }
  //
  // public _deleteUser(UserId: string): void {
  //   this.loadingService.show();
  //   this.subscriptions.push(this.userService.deleteUser(UserId).subscribe(() => {
  //     this._updateUsers();
  //   }));
  // }
  //
  // private refreshUsers(): void {
  //   this.editableUser = new User();
  // }

  // private loadBillingAccounts(): void {
  //   this.loadingService.show();
  //   // Get data from BillingAccountService
  //   this.subscriptions.push(this.billingAccountService.getBillingAccounts().subscribe(accounts => {
  //     // Parse json response into local array
  //     this.billingAccounts = accounts as BillingAccount[];
  //     // Check data in console
  //     console.log(this.billingAccounts);// don't use console.log in angular :)
  //     this.loadingService.hide();
  //   }));
  // }

  ngOnDestroy(): void {
    this.subscriptions.forEach(subscription => subscription.unsubscribe());
  }

}
