package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.Model.WorkReport;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.hrpService.EmployeeInterF;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerformsnceReating extends AppCompatActivity {
    TextView empId, ratingDat, empName, jobKnowledgeCmnt, workqualityCmnt, attendanceCmnt, productivityCmnt, communicationSkillsCmnt, dependabilityCmnt, additionalCmnt;
    RatingBar jobKnowledge, workquality, attendance, productivity, communicationSkills, dependability;
    Button storeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performsnce_reating);

        empName = findViewById(R.id.eName);
        ratingDat = findViewById(R.id.ratingDate);
        jobKnowledge = findViewById(R.id.jobKnowledge);
        workquality = findViewById(R.id.workqualit);
        attendance = findViewById(R.id.attendance);
        productivity = findViewById(R.id.productivity);
        communicationSkills = findViewById(R.id.cmSkills);
        dependability = findViewById(R.id.dependability);
        storeBtn = findViewById(R.id.storeBtn);


        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*String name = empName.getText().toString();
                String ratingDate = ratingDat.getText().toString();
                double jobKnoldg = jobKnowledge.getRating();
                double attend = attendance.getRating();
                double productiv = productivity.getRating();
                double commSkills = communicationSkills.getRight();

                double dependbl = dependability.getRating();
                double overAllScore = jobKnoldg+attend+productiv+commSkills+dependbl;



                EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
                EmpRating workReport = new EmpRating(name,ratingDate,String.valueOf(jobKnoldg),String.valueOf(attend),String.valueOf(productiv),String.valueOf(commSkills),String.valueOf(dependbl),String.valueOf(overAllScore));
                Call<EmpRating> call = service.storePerformanceRating(workReport);
                call.enqueue(new Callback<EmpRating>() {
                    @Override
                    public void onResponse(Call<EmpRating> call, Response<EmpRating> response) {
                        if(response.isSuccessful()){
                            Log.d("test","Reating Success......");
                        }else if(!response.isSuccessful()){
                            Log.d("test", "Rating request Fil");
                        }
                    }

                    @Override
                    public void onFailure(Call<EmpRating> call, Throwable t) {

                    }
                });
*/
                Log.d("test","Reating Success......");
            }
        });


    }
}
