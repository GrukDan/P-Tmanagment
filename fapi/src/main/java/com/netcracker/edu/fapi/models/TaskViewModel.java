package com.netcracker.edu.fapi.models;

import java.util.Arrays;
import java.util.Date;

public class TaskViewModel {
    private Long idTask;
    private String taskCode;
    private String taskName;
    private Object priority;
    private Object status;
    private Date dateOfCreation;
    private Date dueDate;
    private Date updated;
    private String description;

    private Long idProject;
    private String projectName;

    private Long taskCreatorId;
    private String taskCreatorName;
    private String taskCreatorSurname;

    private Long executorId;
    private String executorName;
    private String executorSurname;
    private User[]  executors;

    public TaskViewModel(){}
    public TaskViewModel(Task task){
        this.idTask = task.getIdTask();
        this.taskCode = task.getTaskCode();
        this.taskName = task.getTaskName();
        this.priority = task.getPriority();
        this.status = task.getStatus();
        this.dateOfCreation = task.getDateOfCreation();
        this.dueDate = task.getDueDate();
        this.updated = task.getUpdated();
        this.description = task.getDescription();
        this.taskCreatorId = task.getTaskCreator();
        this.executorId = task.getExecutor();
        this.idProject = task.getIdProject();
    }

    public String getTaskCreatorSurname() {
        return taskCreatorSurname;
    }

    public void setTaskCreatorSurname(String taskCreatorSurname) {
        this.taskCreatorSurname = taskCreatorSurname;
    }

    public String getExecutorSurname() {
        return executorSurname;
    }

    public void setExecutorSurname(String executorSurname) {
        this.executorSurname = executorSurname;
    }

    public TaskViewModel(Long idTask, String taskCode, String taskName, Object priority, Object status, Date dateOfCreation, Date dueDate, Date updated, String description, Long idProject, String projectName, Long taskCreatorId, String taskCreatorName, String taskCreatorSurname, Long executorId, String executorName, String executorSurname, User[] executors) {
        this.idTask = idTask;
        this.taskCode = taskCode;
        this.taskName = taskName;
        this.priority = priority;
        this.status = status;
        this.dateOfCreation = dateOfCreation;
        this.dueDate = dueDate;
        this.updated = updated;
        this.description = description;
        this.idProject = idProject;
        this.projectName = projectName;
        this.taskCreatorId = taskCreatorId;
        this.taskCreatorName = taskCreatorName;
        this.taskCreatorSurname = taskCreatorSurname;
        this.executorId = executorId;
        this.executorName = executorName;
        this.executorSurname = executorSurname;
        this.executors = executors;
    }

    public Task getTask(){
        Task task = new Task();
        task.setIdTask(idTask);
        task.setTaskName(taskName);
        task.setPriority(priority);
        task.setStatus(status);
        task.setDateOfCreation(dateOfCreation);
        task.setDueDate(dueDate);
        task.setUpdated(updated);
        task.setDescription(description);
        task.setTaskCode(taskCode);
        task.setTaskCreator(taskCreatorId);
        task.setExecutor(executorId);
        task.setIdProject(idProject);
        return task;
    }

    @Override
    public String toString() {
        return "TaskViewModel{" +
                "idTask=" + idTask +
                ", taskCode='" + taskCode + '\'' +
                ", taskName='" + taskName + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", dateOfCreation=" + dateOfCreation +
                ", dueDate=" + dueDate +
                ", updated=" + updated +
                ", description='" + description + '\'' +
                ", idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", taskCreatorId=" + taskCreatorId +
                ", taskCreatorName='" + taskCreatorName + '\'' +
                ", taskCreatorSurname='" + taskCreatorSurname + '\'' +
                ", executorId=" + executorId +
                ", executorName='" + executorName + '\'' +
                ", executorSurname='" + executorSurname + '\'' +
                ", executors=" + Arrays.toString(executors) +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
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

    public Long getTaskCreatorId() {
        return taskCreatorId;
    }

    public void setTaskCreatorId(Long taskCreatorId) {
        this.taskCreatorId = taskCreatorId;
    }

    public String getTaskCreatorName() {
        return taskCreatorName;
    }

    public void setTaskCreatorName(String taskCreatorName) {
        this.taskCreatorName = taskCreatorName;
    }

    public Long getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Long executorId) {
        this.executorId = executorId;
    }

    public String getExecutorName() {
        return executorName;
    }

    public void setExecutorName(String executorName) {
        this.executorName = executorName;
    }

    public User[] getExecutors() {
        return executors;
    }

    public void setExecutors(User[] executors) {
        this.executors = executors;
    }
}
