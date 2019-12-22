package com.netcracker.edu.backend.PaginationModels;

import com.netcracker.edu.backend.entity.Task;

import java.util.List;

public class TaskPaginationModelResponse {
    private long pagesCount;
    private int pageNumber;
    private Task[] tasksOnPage;

    @Override
    public String toString() {
        return "TaskPaginationModelResponse{" +
                "pagesCount=" + pagesCount +
                ", pageNumber=" + pageNumber +
                ", tasksOnPage=" + tasksOnPage +
                '}';
    }

    public TaskPaginationModelResponse(long pagesCount, int pageNumber, Task[] tasksOnPage) {
        this.pagesCount = pagesCount;
        this.pageNumber = pageNumber;
        this.tasksOnPage = tasksOnPage;
    }

    public TaskPaginationModelResponse(){}

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

    public Task[] getTasksOnPage() {
        return tasksOnPage;
    }

    public void setTasksOnPage(Task[] tasksOnPage) {
        this.tasksOnPage = tasksOnPage;
    }
}
