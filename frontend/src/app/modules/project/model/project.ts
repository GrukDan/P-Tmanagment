export class Project {
  projectName: string;
  projectCode: string;
  dateOfCompletion: string;
  projectCreator: string;
  readinessDegree: number;
  descriptionOfProject: string;

  static cloneBase(project: Project): Project {
    const clonedProject: Project = new Project();
    clonedProject.projectName = project.projectName;
    clonedProject.projectCode = project.projectCode;
    clonedProject.dateOfCompletion = project.dateOfCompletion;
    clonedProject.projectCreator = project.projectCreator;
    clonedProject.readinessDegree = project.readinessDegree;
    clonedProject.descriptionOfProject = project.descriptionOfProject;
        return clonedProject;
  }
}
