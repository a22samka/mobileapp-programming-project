package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DjurAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Djur> apor;

    public DjurAdapter(List<Djur> apor) {
        this.apor = apor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_holder, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(apor.get(position).getName());
        holder.size.setText(String.valueOf(apor.get(position).getSize()));
    }

    @Override
    public int getItemCount() {
        return apor.size();
    }

}

