import {User} from "../../user/model/user";
import {UserViewModel} from "../../user/model/userViewModel";

export class TaskViewModel {
  idTask:string;
  taskName: string;
  taskCode: string;
  priority: string;
  status: string;
  dateOfCreation: string;
  dueDate: string;
  updated: string;
  description: string;

  idProject : string;
  projectName : string;

  taskCreatorId: string;
  taskCreatorName: string;
  taskCreatorSurname: string;

  executorId: string;
  executorName: string;
  executorSurname: string;
//executor:Executor;

  executors:UserViewModel[];
}


// type Executor{
//   executorId: string;
//   executorName: string;
//   executorSurname: string;
// }
