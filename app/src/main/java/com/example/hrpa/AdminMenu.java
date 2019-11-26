package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminMenu extends AppCompatActivity implements View.OnClickListener {

    private CardView managementCardView, appraisalCardView, employeeCardView, aboutCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        managementCardView = findViewById(R.id.employeeManagement);
        appraisalCardView = findViewById(R.id.employeeAppraisal);
        employeeCardView = findViewById(R.id.employee);
        aboutCardView = findViewById(R.id.aboutUs);


        managementCardView.setOnClickListener(this);
        appraisalCardView.setOnClickListener(this);
        employeeCardView.setOnClickListener(this);
        aboutCardView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.employeeManagement){
            Intent intent = new Intent(getApplicationContext(), EmployeeManagement.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.employeeAppraisal){
            Intent intent = new Intent(getApplicationContext(), EmployeeAppraisal.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.employee){
            Intent intent = new Intent(getApplicationContext(), AddEmployee.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.aboutUs){
           // Intent intent = new Intent(getApplicationContext(), AboutUs.class);
            //startActivity(intent);
        }
    }
}
