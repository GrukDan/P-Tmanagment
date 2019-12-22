import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { BsDropdownModule } from "ngx-bootstrap/dropdown";
import { TooltipModule } from "ngx-bootstrap/tooltip";
import { ModalModule } from "ngx-bootstrap/modal";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {RouterModule, Routes} from "@angular/router";

import {  AngularFontAwesomeModule }  from 'angular-font-awesome';
import {  MDBBootstrapModule }  from 'angular-bootstrap-md';
import { CollapseModule } from 'ngx-bootstrap/collapse'
import {CarouselComponent} from "./modules/header/carousel/carousel.component";
import {FirstPageComponent} from "./modules/first-page/first_page.component";
import  {NotFoundPageComponent} from "./modules/not-found-page/not-found-page.component";
import {ProjectComponent} from "./modules/project/component/project.component";
import {TaskComponent} from "./modules/task/component/task.component";
import {HeaderModule} from "./modules/header/head/header.module";
import {AccountComponent} from "./modules/user/component/account.component";
import {SearchResultComponent} from "./modules/search-result-table/search-result.component";
import {AccountsTableComponent} from "./modules/accounts/accounts-table.component";
import {TasksTableComponent} from "./modules/tasks-table/tasks-table.component";

const appRoutes: Routes = [
  {path: "", component: FirstPageComponent},
  {path: 'project/:id', component: ProjectComponent},
  {path: 'task/:id', component: TaskComponent},
  {path: 'account/:id', component: AccountComponent},
  {path: 'search/:search', component: SearchResultComponent},
  {path: 'accounts', component: AccountsTableComponent},
  {path: 'tasks', component: TasksTableComponent},
  {path: "**", component: NotFoundPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CarouselComponent,
    FirstPageComponent,
    NotFoundPageComponent,

  ],
  imports: [
    HeaderModule,

    BrowserModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BsDropdownModule.forRoot(),
    TooltipModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule.forRoot(appRoutes),
    MDBBootstrapModule.forRoot(),
    AngularFontAwesomeModule,
    CollapseModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
