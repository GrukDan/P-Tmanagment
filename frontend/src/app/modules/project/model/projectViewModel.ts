import {Task} from "../../task/model/task";

export class ProjectViewModel {
  idProject:string;
  projectName: string;
  projectCode: string;
  dateCompletion: string;
  projectCreator: string; //id
  readinessDegree: number;
  description: string;

  projectCreatorName: string;
  projectCreatorSurname:string;

  tasks:Task[];
}
