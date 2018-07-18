package com.example.admin.github.mvp.main;

import android.support.annotation.NonNull;

import com.example.admin.github.data.DataManager;
import com.example.admin.github.data.model.User;
import com.example.admin.github.mvp.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {
    private DataManager dataManager;

    public Call<List<User>> callUsers;

    public MainPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainContract.View view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadUsers() {
        if (getMvpView() != null) {
            getMvpView().showProgress();

            callUsers = dataManager.getUsers();
            callUsers.enqueue(new Callback<List<User>>() {
                @Override
                public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                    if (getMvpView() != null) {
                        getMvpView().hideProgress();

                        if (response.isSuccessful()) {
                            getMvpView().showUsers(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable t) {
                    if (getMvpView() != null) {
                        getMvpView().showNoConnection();
                        getMvpView().hideProgress();
                    }
                }
            });
        }
    }
}
