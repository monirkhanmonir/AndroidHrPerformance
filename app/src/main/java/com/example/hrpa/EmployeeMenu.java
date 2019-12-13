package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.hrpa.SharePreferance.HrpSharePreferance;

public class EmployeeMenu extends AppCompatActivity {
    private CardView empOwnPerform, empLogout, gnrtReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);
        empOwnPerform = findViewById(R.id.empOwnperform);
        empLogout = findViewById(R.id.logout);
        gnrtReport =  findViewById(R.id.eReport);

        empOwnPerform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeMenu.this,EmpOwnPerformance.class);
            startActivity(intent);
            }
        });

        gnrtReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeMenu.this, GenerateReport.class);
                startActivity(intent);
            }
        });

        empLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = HrpSharePreferance.getSharePreferance(getApplicationContext());
                sp.edit().remove("userName").commit();

                Intent intent = new Intent(EmployeeMenu.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }




}
