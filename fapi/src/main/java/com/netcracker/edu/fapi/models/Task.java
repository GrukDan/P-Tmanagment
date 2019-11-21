package com.netcracker.edu.fapi.models;

import java.util.Date;

public class Task {
    private Long idTask;
    private String taskName;
    private Object priority;
    private Object status;
    private Date dateOfCreation;
    private Date dueDate;
    private Date updated;
    private String description;
    private Long executor;
    private Long idProject;
    private String taskCode;
    private Long taskCreator;

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Object getPriority() {
        return priority;
    }

    public void setPriority(Object priority) {
        this.priority = priority;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getExecutor() {
        return executor;
    }

    public void setExecutor(Long executor) {
        this.executor = executor;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public Long getTaskCreator() {
        return taskCreator;
    }

    public void setTaskCreator(Long taskCreator) {
        this.taskCreator = taskCreator;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", dateOfCreation=" + dateOfCreation +
                ", dueDate=" + dueDate +
                ", updated=" + updated +
                ", description='" + description + '\'' +
                ", executor=" + executor +
                ", idProject=" + idProject +
                ", taskCode='" + taskCode + '\'' +
                ", taskCreator=" + taskCreator +
                '}';
    }
}
