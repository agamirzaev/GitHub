package com.example.admin.github.ul.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.github.R;
import com.example.admin.github.data.model.User;
import com.example.admin.github.ul.main.UserDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterHolder> {
    public static String USER_NAME = "ID";

    List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }


    @NonNull
    @Override
    public UserAdapter.UserAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        UserAdapterHolder userViewHolder = new UserAdapterHolder(itemView);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserAdapterHolder holder, int position) {
        User user = users.get(position);

        holder.usersName.setText(user.getUserName());
        holder.usersDescription.setText(user.getUserDescription());
        holder.usersEmail.setText(user.getUserEmail());
        Picasso.with(holder.itemView.getContext())
                .load(user.getUserImage())
                .into(holder.usersImage);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserAdapterHolder extends RecyclerView.ViewHolder {
        TextView usersName, usersEmail, usersDescription;
        ImageView usersImage;

        public UserAdapterHolder(final View itemView) {
            super(itemView);
            usersName = itemView.findViewById(R.id.users_name);
            usersEmail = itemView.findViewById(R.id.users_email);
            usersDescription = itemView.findViewById(R.id.users_description);
            usersImage = itemView.findViewById(R.id.image_users);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, UserDetailsActivity.class);
                    intent.putExtra(USER_NAME, usersName.getText().toString());
                    context.startActivity(intent);
                }
            });
        }
    }
}
