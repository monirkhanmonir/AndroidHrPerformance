package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class PerformsnceReating extends AppCompatActivity {
    TextView empId,ratingDate,empName,jobKnowledgeCmnt,workqualityCmnt,attendanceCmnt,productivityCmnt,communicationSkillsCmnt,dependabilityCmnt,additionalCmnt;
    RatingBar jobKnowledge,workquality,attendance,productivity,communicationSkills,dependability,overallRating;
    Button storeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performsnce_reating);

        empName = findViewById(R.id.eName);
        ratingDate = findViewById(R.id.ratingDate);
        jobKnowledge = findViewById(R.id.jobKnowledge);
        workquality  =findViewById(R.id.workqualit);
        attendance = findViewById(R.id.attendance);
        productivity = findViewById(R.id.productivity);
        communicationSkills = findViewById(R.id.cmSkills);
        dependability = findViewById(R.id.dependability);
        storeBtn = findViewById(R.id.storeBtn);



        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  

            }
        });




    }
}
