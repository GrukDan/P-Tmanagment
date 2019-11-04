export class Task {
  taskName: string;
  taskCode: string;
  taskCreator: string;
  priority: string;
  status: string;
  taskPerformer: string;
  dateOfCreation: string;
  dueDate: string;
  update: string;
  descriptionOfTask: string;

  static cloneBase(task: Task): Task {
    const clonedTask: Task = new Task();
    clonedTask.taskName = task.taskName;
    clonedTask.taskCode = task.taskCode;
    clonedTask.taskCreator = task.taskCreator;
    clonedTask.priority = task.priority;
    clonedTask.status = task.status;
    clonedTask.taskPerformer = task.taskPerformer;
    clonedTask.dateOfCreation = task.dateOfCreation;
    clonedTask.dueDate = task.dueDate;
    clonedTask.update = task.update;
    clonedTask.descriptionOfTask = task.descriptionOfTask;
    return clonedTask;
  }
}
