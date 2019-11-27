package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.hrpa.SharePreferance.HrpSharePreferance;

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

                SharedPreferences sp = HrpSharePreferance.getSharePreferance(getApplicationContext());
                sp.edit().remove("userName").commit();
                Intent intent = new Intent(ManagerMenu.this,MainActivity.class);
                startActivity(intent);
            }
        });

        

    }
}
