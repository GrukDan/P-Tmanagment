package com.netcracker.edu.fapi.models.ViewModels;

import com.netcracker.edu.fapi.models.Project;
import com.netcracker.edu.fapi.models.Task;

import java.util.Arrays;
import java.util.Date;

public class ProjectViewModel {
    private Long idProject;
    private String projectName;
    private Date dateCompletion;
    private Double readinessDegree;
    private String description;
    private String projectCode;
    private Long projectCreator;

    private String projectCreatorName;
    private String projectCreatorSurname;

    private Task[] tasks;

    public ProjectViewModel() {
    }

    public ProjectViewModel(Project project) {
        this.idProject = project.getIdProject();
        this.projectName = project.getProjectName();
        this.dateCompletion = project.getDateCompletion();
        this.readinessDegree = project.getReadinessDegree();
        this.description = project.getDescription();
        this.projectCode = project.getProjectCode();
        this.projectCreator = project.getProjectCreator();
    }

    public Project getProject(){
        Project project = new Project();
        project.setIdProject(idProject);
        project.setProjectName(projectName);
        project.setProjectCode(projectCode);
        project.setDateCompletion(dateCompletion);
        project.setDescription(description);
        project.setProjectCreator(projectCreator);
        project.setReadinessDegree(readinessDegree);
        return project;
    }

    @Override
    public String toString() {
        return "ProjectVIewModel{" +
                "idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", dateCompletion=" + dateCompletion +
                ", readinessDegree=" + readinessDegree +
                ", description='" + description + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", projectCreator=" + projectCreator +
                ", projectCreatorName='" + projectCreatorName + '\'' +
                ", projectCreatorSurname='" + projectCreatorSurname + '\'' +
                ", tasks=" + Arrays.toString(tasks) +
                '}';
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDateCompletion() {
        return dateCompletion;
    }

    public void setDateCompletion(Date dateCompletion) {
        this.dateCompletion = dateCompletion;
    }

    public Double getReadinessDegree() {
        return readinessDegree;
    }

    public void setReadinessDegree(Double readinessDegree) {
        this.readinessDegree = readinessDegree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Long getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(Long projectCreator) {
        this.projectCreator = projectCreator;
    }

    public String getProjectCreatorName() {
        return projectCreatorName;
    }

    public void setProjectCreatorName(String projectCreatorName) {
        this.projectCreatorName = projectCreatorName;
    }

    public String getProjectCreatorSurname() {
        return projectCreatorSurname;
    }

    public void setProjectCreatorSurname(String projectCreatorSurname) {
        this.projectCreatorSurname = projectCreatorSurname;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public ProjectViewModel(Long idProject, String projectName, Date dateCompletion, Double readinessDegree, String description, String projectCode, Long projectCreator, String projectCreatorName, String projectCreatorSurname, Task[] tasks) {
        this.idProject = idProject;
        this.projectName = projectName;
        this.dateCompletion = dateCompletion;
        this.readinessDegree = readinessDegree;
        this.description = description;
        this.projectCode = projectCode;
        this.projectCreator = projectCreator;
        this.projectCreatorName = projectCreatorName;
        this.projectCreatorSurname = projectCreatorSurname;
        this.tasks = tasks;
    }
}
