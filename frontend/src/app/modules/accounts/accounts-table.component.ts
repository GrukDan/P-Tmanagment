import {Component, OnInit} from "@angular/core";
import {UserViewModel} from "../user/model/userViewModel";
import {UserService} from "../user/services/user.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'accounts-table',
  templateUrl: './accounts-table.html',
  styleUrls: ['./style.css']
})
export class AccountsTableComponent implements OnInit {
  public accounts: UserViewModel[] = [];
  public subscriptions: Subscription[] = [];
  public sortFlag: boolean = true;

  public constructor(private userService: UserService,
  ) {
  }

  ngOnInit(): void {
    this.loadusers(this.sortFlag);
  }

  private loadusers(sortFlag:boolean): void {
    this.subscriptions.push(this.userService.getUsersSortByName(10, 10, sortFlag).subscribe(account => {
      this.accounts = account as UserViewModel[];
    }));
  }


  public sortByName():void{
    this.sortFlag=!this.sortFlag;
    this.loadusers(this.sortFlag);
  }

}
