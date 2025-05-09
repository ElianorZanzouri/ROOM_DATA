package com.example.room_data.roomdata.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.room_data.roomdata.entities.Student;

import java.util.List;

//Functions
@Dao
public interface StudentDAO {

    //Select
    @Query("SELECT * FROM students")
    List<Student> getAllStudents();

    @Query("SELECT * FROM students WHERE tehudat_zeut LIKE :tz LIMIT 1")
    Student getStudentByTZ(String tz);


    @Query("SELECT * FROM students WHERE average > :avg")
    List<Student> getStudentsByAverage(double avg);

    //Insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertStudent(Student student);

    //Delete
    @Delete
    void deleteStudent(Student student);
    //Update: @Update void updateStudent(Student student)

}
