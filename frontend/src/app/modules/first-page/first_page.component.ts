import {Component} from "@angular/core";
import {BsModalService} from "ngx-bootstrap";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";
import {ActivatedRoute} from "@angular/router";
import {UserService} from "../user/services/user.service";
import {ProjectService} from "../project/services/project.service";
import {TaskService} from "../task/services/task.service";

@Component({
  selector: 'firstPage',
  templateUrl: "./first_page.html",
})
export class FirstPageComponent{

}
