package com.netcracker.edu.fapi.models;

import java.util.Date;

public class Project {
    private Long idProject;
    private String projectName;
    private Date dateCompletion;
    private Double readinessDegree;
    private String description;
    private String projectCode;
    private Long projectCreator;

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

    @Override
    public String toString() {
        return "Project{" +
                "idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", dateCompletion=" + dateCompletion +
                ", readinessDegree=" + readinessDegree +
                ", description='" + description + '\'' +
                ", projectCode='" + projectCode + '\'' +
                ", projectCreator=" + projectCreator +
                '}';
    }
}
