package com.example.uaspb.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapterGaleri extends RecyclerView.Adapter<adapterGaleri.viewholder> {

    @NonNull
    @Override
    public adapterGaleri.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull adapterGaleri.viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder {
        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
