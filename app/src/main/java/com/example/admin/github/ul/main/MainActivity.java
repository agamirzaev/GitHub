package com.example.admin.github.ul.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.github.R;
import com.example.admin.github.data.model.User;
import com.example.admin.github.mvp.main.MainContract;
import com.example.admin.github.mvp.main.MainPresenter;
import com.example.admin.github.ul.App;
import com.example.admin.github.ul.adapter.UserAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    UserAdapter userAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    private MainPresenter presenter;
    private TextView textView;
    private TextView error_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView =  findViewById(R.id.text_bar);
        error_bar =  findViewById(R.id.error_bar);

        recyclerView =  findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        presenter = new MainPresenter(((App) getApplication()).getDataManager());
        presenter.attachView(this);
        presenter.loadUsers();
    }

    @Override
    public void showUsers(List<User> users) {
        if (userAdapter == null){
            userAdapter = new UserAdapter(users);
            recyclerView.setAdapter(userAdapter);
        }
    }

    @Override
    public void showProgress() {
        textView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        textView.setVisibility(View.GONE);
    }

    @Override
    public void showNoConnection() {
        error_bar.setVisibility(View.VISIBLE);
    }
}
