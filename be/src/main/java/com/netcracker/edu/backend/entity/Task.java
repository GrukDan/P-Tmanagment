package com.netcracker.edu.backend.entity;

import com.netcracker.edu.backend.entity.enums.PriorityEnum;
import com.netcracker.edu.backend.entity.enums.StatusEnum;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "task")
public class Task {
    private long idTask;
    private String taskName;
    private PriorityEnum priority;
    private StatusEnum status;
    private Date dateOfCreation;
    private Date dueDate;
    private Date updated;
    private String description;
    private long executor;
    private long idProject;
    private String taskCode;
    private long taskCreator;

    @Id
    @Column(name = "id_task")
    public long getIdTask() {
        return idTask;
    }

    public void setIdTask(long idTask) {
        this.idTask = idTask;
    }

    @Basic
    @Column(name = "task_name")
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Basic
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Basic
    @Column(name = "date_of_creation")
    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    @Basic
    @Column(name = "due_date")
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "updated")
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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
    @Column(name = "executor")
    public long getExecutor() {
        return executor;
    }

    public void setExecutor(long executor) {
        this.executor = executor;
    }

    @Basic
    @Column(name = "id_project")
    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    @Basic
    @Column(name = "task_code")
    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    @Basic
    @Column(name = "task_creator")
    public long getTaskCreator() {
        return taskCreator;
    }

    public void setTaskCreator(long taskCreator) {
        this.taskCreator = taskCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idTask == task.idTask &&
                idProject == task.idProject &&
                taskCreator == task.taskCreator &&
                Objects.equals(taskName, task.taskName) &&
                Objects.equals(priority, task.priority) &&
                Objects.equals(status, task.status) &&
                Objects.equals(dateOfCreation, task.dateOfCreation) &&
                Objects.equals(dueDate, task.dueDate) &&
                Objects.equals(updated, task.updated) &&
                Objects.equals(description, task.description) &&
                Objects.equals(executor, task.executor) &&
                Objects.equals(taskCode, task.taskCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTask, taskName, priority, status, dateOfCreation, dueDate, updated, description, executor, idProject, taskCode, taskCreator);
    }

    @Override
    public String toString() {
        return "Task{" +
                "idTask=" + idTask +
                ", taskName='" + taskName + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
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
