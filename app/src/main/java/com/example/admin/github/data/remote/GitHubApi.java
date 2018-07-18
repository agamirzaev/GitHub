package com.example.admin.github.data.remote;

import com.example.admin.github.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubApi {
    @GET("users")
    Call<List<User>> getUsers();
}
