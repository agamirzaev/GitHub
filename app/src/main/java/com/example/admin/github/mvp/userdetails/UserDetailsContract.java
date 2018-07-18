package com.example.admin.github.mvp.userdetails;

import com.example.admin.github.data.model.User;
import com.example.admin.github.mvp.base.MvpPresenter;
import com.example.admin.github.mvp.base.MvpView;

public interface UserDetailsContract {
    interface View extends MvpView {
        void showUser(User user);

        void showProgress();

        void hideProgress();

        void showNoConnections();

    }

    interface DetailsPresenter extends MvpPresenter<View> {
        void loadUserDetails(String login);
    }
}
