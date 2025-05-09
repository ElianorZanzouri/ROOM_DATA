package com.example.room_data.roomdata.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.room_data.roomdata.DAO.StudentDAO;
import com.example.room_data.roomdata.entities.Student;

@Database(entities = {Student.class}, version=1)
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase database;

    //create database?
    public static synchronized StudentDatabase getInstance(Context context){
        if(database==null){
            //database not exists
            database= Room.databaseBuilder(
                    context.getApplicationContext(),
                    StudentDatabase.class,
                    "student_db")
                    .allowMainThreadQueries()
                    .build();
            //CREATE DATABASE student_db
        }
        //database not null
        return database;
    }

    // functions
    public abstract StudentDAO studentDAO();
}
