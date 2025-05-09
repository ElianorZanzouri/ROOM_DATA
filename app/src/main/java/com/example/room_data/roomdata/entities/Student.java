package com.example.room_data.roomdata.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


//Table
@Entity(tableName = "students",
        indices = {@Index(value="tehudat_zeut", unique = true)})
public class Student {
    //@=SQLite/Room
    @PrimaryKey(autoGenerate = true)//auto increment
    @ColumnInfo(name="student_id")//name in the table "students" (SQLite)
    public int studentId; //name in the code (JAVA)

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name="last_name")
    public String lastName;

    @ColumnInfo(name="tehudat_zeut")
    public String tehudatZeut;

    @ColumnInfo(name="average")
    public double average;

}
