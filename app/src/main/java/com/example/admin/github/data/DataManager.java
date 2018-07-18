package com.example.admin.github.data;

import com.example.admin.github.data.model.User;
import com.example.admin.github.data.remote.GitHubApi;
import com.example.admin.github.data.remote.ServicesGenerator;

import java.util.List;

import retrofit2.Call;

public class DataManager {
    public Call<List<User>> getUsers(){
        return ServicesGenerator.createService(GitHubApi.class).getUsers();
    }



}
