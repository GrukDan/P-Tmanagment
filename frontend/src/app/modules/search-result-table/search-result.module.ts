import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TaskService} from "../task/services/task.service";
import {SearchResultComponent} from "./search-result.component";
import { PaginationModule } from 'ngx-bootstrap/pagination';


@NgModule({
  declarations: [
    SearchResultComponent,

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
  exports: [SearchResultComponent]
})
export class  SearchResultModule {
}
