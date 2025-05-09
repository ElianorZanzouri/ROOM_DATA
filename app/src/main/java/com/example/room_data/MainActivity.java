package com.example.room_data;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.room_data.roomdata.Database.StudentDatabase;
import com.example.room_data.roomdata.entities.Student;

import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText edtFirstName,edtLastName,edtTZ,edtAverage;
    Button btn;
    RecyclerView recyclerView;
    StudentDatabase db;
    StudentAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirstName=findViewById(R.id.edtFirstName);
        edtLastName=findViewById(R.id.edtLastName);
        edtTZ=findViewById(R.id.edtTZ);
        edtAverage=findViewById(R.id.edtAverage);
        btn=findViewById(R.id.btnSave);
        recyclerView=findViewById(R.id.recyclerViewStudent);

        //database created?
        db=StudentDatabase.getInstance(this);//this:this page

        //recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new StudentAdapter();
        recyclerView.setAdapter(adapter);

        //loading
        loadStudents();

        //btn on Click: new Student in the table

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStudent();
            }
        });
    }

    private void saveStudent() {
        String firstName=edtFirstName.getText().toString().trim();
        String lastName=edtLastName.getText().toString().trim();
        String tz=edtTZ.getText().toString().trim();
        String averageS=edtAverage.getText().toString().trim();


        //empty?
        if(firstName.isEmpty() ||lastName.isEmpty() || tz.isEmpty() ||averageS.isEmpty()){
            Toast.makeText(this, "Empty",Toast.LENGTH_LONG);
            return;
        }

        //average: String -> double

        double average;
        try{
            average=Double.parseDouble(averageS);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        Student student=new Student();
        student.firstName=firstName;
        student.lastName=lastName;
        student.tehudatZeut=tz;
        student.average=average;

        Executors.newSingleThreadExecutor().execute(()->{
                db.studentDAO().insertStudent(student);

                runOnUiThread(()->{
                    clearFields();
                    loadStudents();
                });}
        );


    }

    private void clearFields() {
        edtFirstName.setText("");
        edtLastName.setText("");
        edtTZ.setText("");
        edtAverage.setText("");
    }

    private void loadStudents() {
        Executors.newSingleThreadExecutor().execute(
                ()->{
                    List<Student> studentList=db.studentDAO().getAllStudents();
                    runOnUiThread(()->adapter.setStudent(studentList));
                }
        );
    }
}