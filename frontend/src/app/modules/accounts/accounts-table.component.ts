import {Component, OnInit} from "@angular/core";
import {UserViewModel} from "../user/model/userViewModel";
import {UserService} from "../user/services/user.service";
import {Subscription} from "rxjs";
import {ActivatedRoute} from "@angular/router";
import {PageChangedEvent} from "ngx-bootstrap";
import {UserPaginationModel} from "../user/model/userPagnationModel";

@Component({
  selector: 'accounts-table',
  templateUrl: './accounts-table.html',
  styleUrls: ['./style.css']
})
export class AccountsTableComponent implements OnInit {
  public userPaginationModel: UserPaginationModel;
  public accounts: UserViewModel[] = [];
  public subscriptions: Subscription[] = [];
  private querySubscription: Subscription;

  public parameters: string[] = ["name", "surname", "email", "role"];
  public pagesCount: number;
  public direction: boolean = true;
  public parameter: string;
  public page: number;
  public size: number;

  public constructor(private userService: UserService,
                     private route: ActivatedRoute
  ) {
    this.parameter = "name";
    this.page = 0;
    this.size = 5;
    this.pagesCount = 11;
    // this.querySubscription = route.queryParams.subscribe(
    //   (queryParam: any) => {
    //     this.parameter = "name";
    //     this.page = 0;
    //     this.size = 5;
    //     this.pagesCount = 11;
    //   });
  }

  ngOnInit(): void {
    this.loadusers(this.page);
  }

  private loadusers(page: number): void {
    this.subscriptions.push(this.userService.getUsersSort(this.parameter, page, this.size, this.direction).subscribe(userPaginationModel => {
      this.userPaginationModel = userPaginationModel;
      this.accounts = this.userPaginationModel.usersOnPage;
      this.pagesCount = (this.userPaginationModel.pagesCount/5) * 10;
      this.accounts.forEach(account => {
        if (account.role == "TESTER") account.role = "Tester";
        else if (account.role == "DEVELOPER") account.role = "Developer";
        else if (account.role == "PROJECT_MANAGER") account.role = "Project manager";
        else account.role = "Admin";
      })
    }));
  }

  public sort(parameter: string): void {
    this.parameter = parameter;
    this.direction = !this.direction;

    this.loadusers(this.page);
  }

  pageChanged(event: PageChangedEvent) {
    this.page = event.page - 1;
    this.loadusers(this.page);
  }
}
