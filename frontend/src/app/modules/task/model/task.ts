export class Task {
  idTask:string;
  taskName: string;
  taskCode: string;
  taskCreator: string;
  priority: string;
  status: string;
  executor: string;
  dateOfCreation: string;
  idProject : string;
  dueDate: string;
  update: string;
  description: string;

  static cloneBase(task: Task): Task {
    const clonedTask: Task = new Task();
    clonedTask.idTask = task.idTask;
    clonedTask.taskName = task.taskName;
    clonedTask.taskCode = task.taskCode;
    clonedTask.taskCreator = task.taskCreator;
    clonedTask.priority = task.priority;
    clonedTask.status = task.status;
    clonedTask.executor = task.executor;
    clonedTask.dateOfCreation = task.dateOfCreation;
    clonedTask.idProject = task.idProject;
    clonedTask.dueDate = task.dueDate;
    clonedTask.update = task.update;
    clonedTask.description = task.description;
    return clonedTask;
  }
}
