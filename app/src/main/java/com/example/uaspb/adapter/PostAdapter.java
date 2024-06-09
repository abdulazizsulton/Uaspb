package com.example.uaspb.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uaspb.response.register.Post;

import java.util.List;

public class PostAdapter {
}


//public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
//
//    private List<Post> postList;
//
//    public PostAdapter(List<Post> postList) {
//        this.postList = postList;
//    }
//
//    @NonNull
//    @Override
//    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);
//        return new PostViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
//        Post post = postList.get(position);
//        holder.textViewUsername.setText(post.getUsername());
//        holder.textViewTime.setText(post.getTime());
//        // holder.imageViewDog.setImageResource(post.getImageResource()); // Set your image resource here
//        holder.buttonLike.setOnClickListener(v -> {
//            // Handle like button click
//        });
//        holder.buttonComment.setOnClickListener(v -> {
//            // Handle comment button click
//        });
//        holder.buttonShare.setOnClickListener(v -> {
//            // Handle share button click
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return postList.size();
//    }
//
//    public static class PostViewHolder extends RecyclerView.ViewHolder {
//
//        TextView textViewUsername;
//        TextView textViewTime;
//        ImageView imageViewDog;
//        Button buttonLike;
//        Button buttonComment;
//        Button buttonShare;
//        EditText editTextComment;
//
//        public PostViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textViewUsername = itemView.findViewById(R.id.textViewUsername);
//            textViewTime = itemView.findViewById(R.id.textViewTime);
//            imageViewDog = itemView.findViewById(R.id.imageViewDog);
//            buttonLike = itemView.findViewById(R.id.buttonLike);
//            buttonComment = itemView.findViewById(R.id.buttonComment);
//            buttonShare = itemView.findViewById(R.id.buttonShare);
//            editTextComment = itemView.findViewById(R.id.editTextComment);
//        }
//    }
//}
