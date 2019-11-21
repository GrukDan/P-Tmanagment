import {User} from "../../user/model/user";

export class TaskViewModel {
  idTask:string;
  taskName: string;
  taskCode: string;
  priority: string;
  status: string;
  dateOfCreation: string;
  dueDate: string;
  update: string;
  description: string;

  idProject : string;
  projectName : string;

  taskCreatorId: string;
  taskCreatorName: string;
  taskCreatorSurname: string;

  executorId: string;
  executorName: string;
  executorSurname: string;
  executors:User[];

}
