import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {TaskService} from "../task/services/task.service";
import { PaginationModule } from 'ngx-bootstrap/pagination';
import {TasksTableComponent} from "./tasks-table.component";

@NgModule({
  declarations: [
    TasksTableComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    PaginationModule.forRoot()
  ],
  providers: [TaskService],
  exports: [TasksTableComponent]
})
export class  TaskTableModule {
}
