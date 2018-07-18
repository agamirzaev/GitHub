package com.example.admin.github.mvp.userdetails;

import android.support.annotation.NonNull;

import com.example.admin.github.data.DataManager;
import com.example.admin.github.data.model.User;
import com.example.admin.github.mvp.base.BasePresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsPresenter extends BasePresenter<UserDetailsContract.View> implements UserDetailsContract.DetailsPresenter {

    private DataManager dataManager;

    private Call<User> userDetailsCall;

    public UserDetailsPresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(UserDetailsContract.View view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void loadUserDetails(String login) {
        if (getMvpView() != null) {
            getMvpView().showProgress();
            userDetailsCall = dataManager.getUserDetails(login);
            userDetailsCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                    if (getMvpView()!=null){
                        getMvpView().hideProgress();

                        if (response.isSuccessful()){
                            getMvpView().showUser(response.body());
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                    if (getMvpView() != null) {
                        getMvpView().showNoConnections();
                        getMvpView().hideProgress();
                    }
                }
            });
        }
    }
}
