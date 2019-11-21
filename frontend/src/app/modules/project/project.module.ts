import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {ProjectService} from "./services/project.service";
import {ProjectComponent} from "./component/project.component";
import {AccordionModule} from "ngx-bootstrap";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    ProjectComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    BrowserAnimationsModule,
    AccordionModule.forRoot(),

  ],

  providers: [ProjectService],
  exports: [ProjectComponent]
})
export class ProjectModule {
}
