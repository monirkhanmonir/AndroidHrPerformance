package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class EmployeeDetails extends AppCompatActivity {

    TextView eId, name, email, user, gender, jobTitle, address, birthDate, joinDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);
        eId = findViewById(R.id.employeeId);
        name = findViewById(R.id.employeeName);
        email = findViewById(R.id.employeeEmail);
        user = findViewById(R.id.employeeUsername);
        gender = findViewById(R.id.employeeGender);
        jobTitle = findViewById(R.id.designation);
        address = findViewById(R.id.address);
        birthDate = findViewById(R.id.employeeDob);
        joinDate = findViewById(R.id.joinDate);


        Intent intent = getIntent();

        String id = intent.getStringExtra("eId");

        Log.d("Id", id.toString());

        eId.setText(id);
        name.setText(intent.getStringExtra("eName"));
        email.setText(intent.getStringExtra("empEmail"));
        user.setText(intent.getStringExtra("user"));
        gender.setText(intent.getStringExtra("gender"));
        jobTitle.setText(intent.getStringExtra("jobTitle"));
        birthDate.setText(intent.getStringExtra("birthDAte"));
        joinDate.setText(intent.getStringExtra("jpinDate"));
        address.setText(intent.getStringExtra("address"));


    }
}
