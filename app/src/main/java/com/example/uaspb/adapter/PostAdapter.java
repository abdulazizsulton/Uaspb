package com.example.uaspb.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uaspb.R;
import com.example.uaspb.response.selectPost.Post;
import com.example.uaspb.response.selectPost.PostData;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<PostData> model;
    private Context context;

    public PostAdapter(Context context, List<PostData> model) {
        this.context = context;
        this.model = model;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostData post = model.get(position);
        holder.textViewUsername.setText(post.getUsername());
        holder.textViewTime.setText(post.getCreatedAt());
        // holder.imageViewDog.setImageResource(post.getImageResource()); // Set your image resource here
        holder.buttonLike.setOnClickListener(v -> {
            // Handle like button click
        });
        holder.buttonComment.setOnClickListener(v -> {
            // Handle comment button click
        });
        holder.buttonShare.setOnClickListener(v -> {
            // Handle share button click
        });
        byte[] imageBytes = Base64.decode(post.getImage().substring(post.getImage().indexOf(",") + 1), Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        holder.imageViewDog.setImageBitmap(bitmap);

        byte[] imageBytes2 = Base64.decode(post.getImage().substring(post.getProfilePicture().indexOf(",") + 1), Base64.DEFAULT);
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes2.length);
        holder.imgProfile.setImageBitmap(bitmap2);


    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewUsername;
        TextView textViewTime;
        ImageView imageViewDog, imgProfile;
        Button buttonLike;
        Button buttonComment;
        Button buttonShare;
        EditText editTextComment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            imageViewDog = itemView.findViewById(R.id.imageViewDog);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            buttonLike = itemView.findViewById(R.id.buttonLike);
            buttonComment = itemView.findViewById(R.id.buttonComment);
            buttonShare = itemView.findViewById(R.id.buttonShare);
            editTextComment = itemView.findViewById(R.id.editTextComment);
        }
    }
}
