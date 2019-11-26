package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ManagerMenu extends AppCompatActivity {

    private CardView appraisalRating, createTask, employeeDetails, aboutCompany;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_menu);

        appraisalRating = findViewById(R.id.appraisalRating);
        createTask = findViewById(R.id.createTask);
        employeeDetails = findViewById(R.id.employeeDetails);
        aboutCompany = findViewById(R.id.aboutCompany);

        appraisalRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AppraisalRating.class);
                startActivity(intent);
            }
        });
        createTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateTask.class);
                startActivity(intent);
            }
        });
        employeeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EmployeeDetailsManager.class);
                startActivity(intent);
            }
        });
        aboutCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(getApplicationContext(), AboutCompany.class);
              //  startActivity(intent);
            }
        });

        

    }
}
