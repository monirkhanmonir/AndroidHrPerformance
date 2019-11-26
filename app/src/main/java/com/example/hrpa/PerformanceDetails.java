package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class PerformanceDetails extends AppCompatActivity {
    RatingBar jobKnowledge, workquality, attendance, productivity, communicationSkills, dependability;
    TextView ratingDate, empName, jobKnowledgeCmnt, workqualityCmnt, attendanceCmnt, productivityCmnt, communicationSkillsCmnt, dependabilityCmnt, additionalCmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance_details);
        jobKnowledge = findViewById(R.id.jobKnowledge);
        workquality = findViewById(R.id.workqualit);
        attendance = findViewById(R.id.attendance);
        productivity = findViewById(R.id.productivity);
        communicationSkills = findViewById(R.id.cmSkills);
        dependability = findViewById(R.id.dependability);


        ratingDate = findViewById(R.id.ratingDate);
        empName = findViewById(R.id.eName);
        jobKnowledge = findViewById(R.id.jobKnowledge);
        jobKnowledgeCmnt = findViewById(R.id.jobKnowledgeCmnt);
        workqualityCmnt = findViewById(R.id.workqualitycmn);
        attendanceCmnt = findViewById(R.id.attendanceCmnt);
        productivityCmnt = findViewById(R.id.productivityCmnt);
        communicationSkillsCmnt = findViewById(R.id.cmSkillsCmnt);
        dependabilityCmnt = findViewById(R.id.dependabilityCmnt);
        //  additionalCmnt = findViewById(R.id.a)

        Intent intent = getIntent();

        ratingDate.setText(intent.getStringExtra("rateDate"));
        empName.setText(intent.getStringExtra("empName"));
        jobKnowledge.setRating(Float.parseFloat(intent.getStringExtra("jobnladge")));
        jobKnowledgeCmnt.setText(intent.getStringExtra("jKnoledgeCmnt"));
        workquality.setRating(Float.parseFloat(intent.getStringExtra("empworkquality")));
        workqualityCmnt.setText(intent.getStringExtra("empworkqualityCmnt"));
        attendance.setRating(Float.parseFloat(intent.getStringExtra("empattendance")));
        attendanceCmnt.setText(intent.getStringExtra("empattendanceCmnt"));
        productivity.setRating(Float.parseFloat(intent.getStringExtra("empproductivity")));
        productivityCmnt.setText(intent.getStringExtra("empproductivityCmnt"));
        communicationSkills.setRating(Float.parseFloat(intent.getStringExtra("empcommunicationSkills")));
        communicationSkillsCmnt.setText(intent.getStringExtra("empcommunicationSkillscmnt"));
        dependability.setRating(Float.parseFloat(intent.getStringExtra("empdependability")));
        dependabilityCmnt.setText(intent.getStringExtra("empdependabilitycmnt"));

    }
}
