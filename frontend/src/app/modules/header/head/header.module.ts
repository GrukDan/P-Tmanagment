import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {Ng4LoadingSpinnerModule} from "ng4-loading-spinner";
import {TaskModule} from "../../task/task.module";
import {ProjectModule} from "../../project/project.module";
import {HeadComponent} from "./app-head.component";
import {UserModule} from "../../user/user.module";
import {SearchResultModule} from "../../search-result-table/search-result.module";
import {AccountsTableModule} from "../../accounts/accounts-table.module";

@NgModule({
  declarations: [
    HeadComponent,

  ],
  imports: [
    TaskModule,
    ProjectModule,
    UserModule,
    SearchResultModule,
    AccountsTableModule,

    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    ReactiveFormsModule,

  ],

  exports: [HeadComponent]
})
export class HeaderModule {
}
