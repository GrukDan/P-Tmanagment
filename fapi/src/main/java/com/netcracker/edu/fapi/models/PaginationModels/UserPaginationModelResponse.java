package com.netcracker.edu.fapi.models.PaginationModels;

import com.netcracker.edu.fapi.models.User;

import java.util.Arrays;

public class UserPaginationModelResponse {

    private long pagesCount;
    private int pageNumber;
    private User[] usersOnPage;

    public UserPaginationModelResponse(){}

    @Override
    public String toString() {
        return "UserPaginationModelResponse{" +
                "pagesCount=" + pagesCount +
                ", pageNumber=" + pageNumber +
                ", usersOnPage=" + Arrays.toString(usersOnPage) +
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

    public User[] getUsersOnPage() {
        return usersOnPage;
    }

    public void setUsersOnPage(User[] usersOnPage) {
        this.usersOnPage = usersOnPage;
    }

    public UserPaginationModelResponse(long pagesCount, int pageNumber, User[] usersOnPage) {
        this.pagesCount = pagesCount;
        this.pageNumber = pageNumber;
        this.usersOnPage = usersOnPage;
    }
}
