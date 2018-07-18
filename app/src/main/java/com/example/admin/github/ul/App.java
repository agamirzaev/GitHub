package com.example.admin.github.ul;

import android.app.Application;

import com.example.admin.github.data.DataManager;

public class App extends Application {
    private DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        dataManager = new DataManager();
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
