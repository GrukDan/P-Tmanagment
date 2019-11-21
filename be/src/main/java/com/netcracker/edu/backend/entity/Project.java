package com.netcracker.edu.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {
    private long idProject;
    private String projectName;
    private Date dateCompletion;
    private Double readinessDegree;
    private String description;
    private String projectCode;
    private long projectCreator;

    @Id
    @Column(name = "id_project")
    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "project_name")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Basic
    @Column(name = "date_completion")
    public Date getDateCompletion() {
        return dateCompletion;
    }

    public void setDateCompletion(Date dateCompletion) {
        this.dateCompletion = dateCompletion;
    }

    @Basic
    @Column(name = "readiness_degree")
    public Double getReadinessDegree() {
        return readinessDegree;
    }

    public void setReadinessDegree(Double readinessDegree) {
        this.readinessDegree = readinessDegree;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "project_code")
    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    @Basic
    @Column(name = "project_creator")
    public long getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(long projectCreator) {
        this.projectCreator = projectCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return idProject == project.idProject &&
                projectCreator == project.projectCreator &&
                Objects.equals(projectName, project.projectName) &&
                Objects.equals(dateCompletion, project.dateCompletion) &&
                Objects.equals(readinessDegree, project.readinessDegree) &&
                Objects.equals(description, project.description) &&
                Objects.equals(projectCode, project.projectCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProject, projectName, dateCompletion, readinessDegree, description, projectCode, projectCreator);
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
