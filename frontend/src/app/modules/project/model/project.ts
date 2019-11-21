export class Project {
  idProject:string;
  projectName: string;
  projectCode: string;
  dateCompletion: string;
  projectCreator: string;
  readinessDegree: number;
  description: string;

  static cloneBase(project: Project): Project {
    const clonedProject: Project = new Project();
    clonedProject.idProject = project.idProject;
    clonedProject.projectName = project.projectName;
    clonedProject.projectCode = project.projectCode;
    clonedProject.dateCompletion = project.dateCompletion;
    clonedProject.projectCreator = project.projectCreator;
    clonedProject.readinessDegree = project.readinessDegree;
    clonedProject.description = project.description;
        return clonedProject;
  }
}
