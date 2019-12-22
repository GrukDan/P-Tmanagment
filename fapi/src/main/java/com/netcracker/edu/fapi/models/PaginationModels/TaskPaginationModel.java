package com.netcracker.edu.fapi.models.PaginationModels;

import com.netcracker.edu.fapi.models.Task;
import com.netcracker.edu.fapi.models.ViewModels.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

public class TaskPaginationModel {

    private long pagesCount;
    private int pageNumber;
    private List<TaskViewModel> tasksOnPage;

    @Override
    public String toString() {
        return "TaskPaginationModel{" +
                "pagesCount=" + pagesCount +
                ", pageNumber=" + pageNumber +
                ", tasksOnPage=" + tasksOnPage +
                '}';
    }

    public long getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(long pagesCount) {
        this.pagesCount = pagesCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<TaskViewModel> getTasksOnPage() {
        return tasksOnPage;
    }

    public void setTasksOnPage(List<TaskViewModel> tasksOnPage) {
        this.tasksOnPage = tasksOnPage;
    }

    public TaskPaginationModel(long pagesCount, int pageNumber, List<TaskViewModel> tasksOnPage) {
        this.pagesCount = pagesCount;
        this.pageNumber = pageNumber;
        this.tasksOnPage = tasksOnPage;
    }

    public TaskPaginationModel(TaskPaginationModelResponse taskPaginationModelResponse) {
        this.pagesCount = taskPaginationModelResponse.getPagesCount();
        this.pageNumber = taskPaginationModelResponse.getPageNumber();
        this.tasksOnPage = new ArrayList<>(taskPaginationModelResponse.getTasksOnPage().length);
        for(Task task:taskPaginationModelResponse.getTasksOnPage()){
            this.tasksOnPage.add(new TaskViewModel(task));
        }
    }
}
