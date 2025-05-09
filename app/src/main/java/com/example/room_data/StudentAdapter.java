package com.example.room_data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_data.roomdata.entities.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private List<Student> studentList=new ArrayList<>();

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_item,parent,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position){
        Student student=studentList.get(position);
        holder.txtStudent.setText("TZ:"+student.tehudatZeut+"--"
                +student.firstName+" "+student.lastName
                +". Average:"+student.average);
    }

    @Override
    public int getItemCount(){return studentList.size();}


    //new Student in the list
    public void setStudent(List<Student> students){
        this.studentList=students;
        notifyDataSetChanged();
    }
}

