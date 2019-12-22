import {TaskViewModel} from "./taskViewModel";

export class TaskPaginationModel {
  pagesCount:number;
  pageNumber:number;
  tasksOnPage:TaskViewModel[];
}
