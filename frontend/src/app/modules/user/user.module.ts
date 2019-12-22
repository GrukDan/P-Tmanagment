import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {Ng4LoadingSpinnerModule} from 'ng4-loading-spinner';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {UserService} from "./services/user.service";
import {AccountComponent} from "./component/account.component";
import {TabsModule} from "ngx-bootstrap";
import {StorageServiceModule} from "angular-webstorage-service";

@NgModule({
  declarations: [
    AccountComponent
  ],
  imports: [
    TabsModule.forRoot(),
    BrowserModule,
    RouterModule,
    FormsModule,
    HttpClientModule,
    Ng4LoadingSpinnerModule.forRoot(),
    StorageServiceModule,
  ],
  exports: [AccountComponent],
  providers: [UserService],
})
export class UserModule {
}
