package com.netcracker.edu.fapi.models;

import java.util.Date;

public class Project {
    private int idProject;
    private String projectName;
    private Date dateCompletion;
    private Double readinessDegree;
    private String description;
    private String projectCode;
    private int projectCreator;

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
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

    public int getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(int projectCreator) {
        this.projectCreator = projectCreator;
    }
}
