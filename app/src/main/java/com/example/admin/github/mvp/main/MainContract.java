package com.example.admin.github.mvp.main;


import com.example.admin.github.data.model.User;
import com.example.admin.github.mvp.base.MvpPresenter;
import com.example.admin.github.mvp.base.MvpView;

import java.util.List;

public interface MainContract {
    interface View extends MvpView {
        void showUsers(List<User> users);

        void showProgress();

        void hideProgress();

        void showNoConnection();

    }

    interface Presenter extends MvpPresenter<View> {
        void loadUsers();
    }

}
