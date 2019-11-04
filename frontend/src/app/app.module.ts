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
import {FirstPageComponent} from "./modules/firstPage/firstPage.component";

import  {NotFoundPageComponent} from "./modules/notFound/notFoundPage.component";
// import {HeadComponent} from "./modules/header/head/appHead.component";
import {ProjectComponent} from "./modules/project/component/project.component";
import {TaskComponent} from "./modules/task/component/task.component";
import {UserModule} from "./modules/user/user.module";

const appRoutes: Routes = [
  {path: "", component: FirstPageComponent},
  {path: 'project', component: ProjectComponent},
  {path: 'task', component: TaskComponent},
   {path: "**", component: NotFoundPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CarouselComponent,
    FirstPageComponent,
    NotFoundPageComponent,
    ProjectComponent,
    // HeadComponent,
     TaskComponent,


  ],
  imports: [
    //почему нужно добавлять сюда??
    UserModule,

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
