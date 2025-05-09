package com.example.room_data;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView txtStudent;
    public StudentViewHolder(@NonNull View itemView){
        super(itemView);

        txtStudent=itemView.findViewById(R.id.txtStudent);
    }
}
