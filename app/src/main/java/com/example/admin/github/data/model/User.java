package com.example.admin.github.data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("avatar_url")
    private String userImage;
    @SerializedName("login")
    private String userName;
    @SerializedName("html_url")
    private String userDescription;
    @SerializedName("type")
    private String userEmail;
    @SerializedName("followers_url")
    private String userFollowing;
    @SerializedName("following_url")
    private String userFollower;


    public String getUserImage() {
        return userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserFollower() {
        return userFollower;
    }

    public String getUserFollowing() {
        return userFollowing;
    }
}
