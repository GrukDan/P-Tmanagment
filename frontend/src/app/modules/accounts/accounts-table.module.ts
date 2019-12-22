import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {TaskService} from "../task/services/task.service";
import {AccountsTableComponent} from "./accounts-table.component";
import {UserService} from "../user/services/user.service";
// import {NgxPaginationModule} from 'ngx-pagination'; // <- импортировать модуль
import { PaginationModule } from 'ngx-bootstrap/pagination';

@NgModule({
  declarations: [
    AccountsTableComponent,

  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    PaginationModule.forRoot()
  ],

  providers: [UserService],
  exports: [AccountsTableComponent]
})
export class  AccountsTableModule {
}
