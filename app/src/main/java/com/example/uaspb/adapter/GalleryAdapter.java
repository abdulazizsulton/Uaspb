package com.example.uaspb.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uaspb.databinding.ItemGaleriBinding;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private final List<String> data;

    public GalleryAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemGaleriBinding binding = ItemGaleriBinding.inflate(inflater, parent, false);
        return new GalleryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        String item = data.get(position);
        // Bind your data here
        // holder.binding.textView.setText(item); // Assuming you have a TextView in your item layout
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class GalleryViewHolder extends RecyclerView.ViewHolder {
        private final ItemGaleriBinding binding;

        public GalleryViewHolder(@NonNull ItemGaleriBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String item) {
            // Here you can bind data to your views
            // For example: binding.textView.setText(item);
        }
    }
}
