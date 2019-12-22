package com.netcracker.edu.fapi.models.PaginationModels;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.ViewModels.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserPaginationModel {

    private long pagesCount;
    private int pageNumber;
    private List<UserViewModel> usersOnPage;

    public UserPaginationModel(UserPaginationModelResponse userPaginationModelResponse){
        this.pagesCount = userPaginationModelResponse.getPagesCount();
        this.pageNumber = userPaginationModelResponse.getPageNumber();
        this.usersOnPage = new ArrayList();

        for(User user: userPaginationModelResponse.getUsersOnPage()){
            this.usersOnPage.add(new UserViewModel(user));
        }
    }

    @Override
    public String toString() {
        return "UserPaginationModel{" +
                "pagesCount=" + pagesCount +
                ", pageNumber=" + pageNumber +
                ", usersOnPage=" + usersOnPage +
                '}';
    }

    public UserPaginationModel(){}

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

    public List<UserViewModel> getUsersOnPage() {
        return usersOnPage;
    }

    public void setUsersOnPage(List<UserViewModel> usersOnPage) {
        this.usersOnPage = usersOnPage;
    }

    public UserPaginationModel(long pagesCount, int pageNumber, List<UserViewModel> usersOnPage) {
        this.pagesCount = pagesCount;
        this.pageNumber = pageNumber;
        this.usersOnPage = usersOnPage;
    }
}
