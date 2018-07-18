package com.example.admin.github.ul.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.github.R;
import com.example.admin.github.data.model.User;
import com.example.admin.github.mvp.userdetails.UserDetailsContract;
import com.example.admin.github.mvp.userdetails.UserDetailsPresenter;
import com.example.admin.github.ul.App;
import com.example.admin.github.ul.adapter.UserAdapter;
import com.squareup.picasso.Picasso;

public class UserDetailsActivity extends AppCompatActivity implements UserDetailsContract.View {
    private UserDetailsPresenter userDetailsPresenter;

    private String login;
    private TextView name, email, description, following, follower;
    private ImageView imageView;

    private TextView textView;
    private TextView error_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        login = getIntent().getStringExtra(UserAdapter.USER_NAME);

        imageView = findViewById(R.id.user_image);
        name = findViewById(R.id.user_name);
        email = findViewById(R.id.user_email);
        description = findViewById(R.id.user_description);
        follower = findViewById(R.id.user_follower);
        following = findViewById(R.id.user_following);

        textView = findViewById(R.id.text_bar);
        error_bar = findViewById(R.id.error_bar);
        error_bar.setVisibility(View.GONE);

        userDetailsPresenter = new UserDetailsPresenter(((App) getApplication()).getDataManager());
        userDetailsPresenter.attachView(this);
        userDetailsPresenter.loadUserDetails(login);
    }

    @Override
    public void showUser(User user) {
        name.setText(user.getUserName());
        email.setText(user.getUserEmail());
        description.setText(user.getUserDescription());
        follower.setText(user.getUserFollower());
        following.setText(user.getUserFollowing());
        Picasso.with(getBaseContext()).load(user.getUserImage()).into(imageView);
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
    public void showNoConnections() {
        error_bar.setVisibility(View.VISIBLE);
    }
}
