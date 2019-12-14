package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.DatePicker;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.hrpService.EmployeeInterF;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerformsnceReating extends AppCompatActivity {
    TextView empId, ratingDat, empName, repoType;
    RatingBar jobKnowledge, workquality, attendance, productivity, communicationSkills, dependability;
    Button storeBtn;
    TextView displayDate;
    String date;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    String jobKnowledgeCmnt, workqualityCmnt, attendanceCmnt, productivityCmnt, communicationSkillsCmnt, dependabilityCmnt, additionalCmnt;
    private static final String TAG = "PerformsnceReating";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performsnce_reating);
        empId = findViewById(R.id.eID);
        empName = findViewById(R.id.eName);
        repoType = findViewById(R.id.repoQuality);
        ratingDat = findViewById(R.id.ratingDate);
        jobKnowledge = findViewById(R.id.performRate);
        workquality = findViewById(R.id.workqualit);
        attendance = findViewById(R.id.attendance);
        productivity = findViewById(R.id.productivity);
        communicationSkills = findViewById(R.id.cmSkillss);
        dependability = findViewById(R.id.dependability);
        storeBtn = findViewById(R.id.storeBtn);
        displayDate = findViewById(R.id.dateSelect);
       // String dateNew=date;


        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(PerformsnceReating.this,
                        android.R.style.Theme_Material_Dialog_MinWidth,
                        onDateSetListener,
                        year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy : " + month + "/" + dayOfMonth + "/" + year);

                date = month + "/" + dayOfMonth + "/" + year;
                displayDate.setText(date);
            }
        };


        Intent intent = getIntent();
       System.out.println("Nmae is : "+intent.getStringExtra("empName"));
        empId.setText(intent.getStringExtra("eId"));
        empName.setText(intent.getStringExtra("empName"));
        repoType.setText(intent.getStringExtra("repoType"));

        storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = empId.getText().toString();
                Log.d("iD_Chack",id);
                int ide = Integer.parseInt(id);
                String name = empName.getText().toString();
              //  String ratingDate = date;
                double jobKnoldg = jobKnowledge.getRating();
                double attend = attendance.getRating();
                double productiv = productivity.getRating();
                double commSkills = communicationSkills.getRating();
                double workqlity = workquality.getRating();
                double dependbl = dependability.getRating();



                //double [] overAll = new double{jobKnoldg,attend,productiv,commSkills,workqlity,dependbl};


                double overAllScore = jobKnoldg + attend + productiv + commSkills + dependbl;

                if (jobKnoldg == 1) {
                    jobKnowledgeCmnt = "Poor";
                } else if (jobKnoldg == 2) {
                    jobKnowledgeCmnt = "Fair";
                } else if (jobKnoldg == 3) {
                    jobKnowledgeCmnt = "Satisfactory";
                } else if (jobKnoldg == 4) {
                    jobKnowledgeCmnt = "Good";
                } else if (jobKnoldg == 5) {
                    jobKnowledgeCmnt = "Excellent";
                }

                if (workqlity == 1) {
                    workqualityCmnt = "Poor";
                } else if (workqlity == 2) {
                    workqualityCmnt = "Fair";
                } else if (workqlity == 3) {
                    workqualityCmnt = "Satisfactory";
                } else if (workqlity == 4) {
                    workqualityCmnt = "Good";
                } else if (workqlity == 5) {
                    workqualityCmnt = "Excellent";
                }


                if (attend == 1) {
                    attendanceCmnt = "Poor";
                } else if (attend == 2) {
                    attendanceCmnt = "Fair";
                } else if (attend == 3) {
                    attendanceCmnt = "Satisfactory";
                } else if (attend == 4) {
                    attendanceCmnt = "Good";
                } else if (attend == 5) {
                    attendanceCmnt = "Excellent";
                }

                if (productiv == 1) {
                    productivityCmnt = "Poor";
                } else if (productiv == 2) {
                    productivityCmnt = "Fair";
                } else if (productiv == 3) {
                    productivityCmnt = "Satisfactory";
                } else if (productiv == 4) {
                    productivityCmnt = "Good";
                } else if (productiv == 5) {
                    productivityCmnt = "Excellent";
                }

                if (commSkills == 1) {
                    communicationSkillsCmnt = "Poor";
                } else if (commSkills == 2) {
                    communicationSkillsCmnt = "Fair";
                } else if (commSkills == 3) {
                    communicationSkillsCmnt = "Satisfactory";
                } else if (commSkills == 4) {
                    communicationSkillsCmnt = "Good";
                } else if (commSkills == 5) {
                    communicationSkillsCmnt = "Excellent";
                }

                if (dependbl == 1) {
                    dependabilityCmnt = "Poor";
                } else if (dependbl == 2) {
                    dependabilityCmnt = "Fair";
                } else if (dependbl == 3) {
                    dependabilityCmnt = "Satisfactory";
                } else if (dependbl == 4) {
                    dependabilityCmnt = "Good";
                } else if (dependbl == 5) {
                    dependabilityCmnt = "Excellent";
                }


                EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
                EmpRating reating = new EmpRating(name,ide, date, jobKnowledgeCmnt, workqualityCmnt, attendanceCmnt, productivityCmnt, communicationSkillsCmnt, dependabilityCmnt, String.valueOf(jobKnoldg), String.valueOf(workqlity), String.valueOf(attend), String.valueOf(productiv), String.valueOf(commSkills), String.valueOf(dependbl), String.valueOf(overAllScore));
                Call<EmpRating> call = service.storePerformanceRating(reating);
                call.enqueue(new Callback<EmpRating>() {
                    @Override
                    public void onResponse(Call<EmpRating> call, Response<EmpRating> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Performance successfully recorded.", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(PerformsnceReating.this, AppraisalRating.class);
                            startActivity(intent1);
                        } else if (!response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Performance record fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EmpRating> call, Throwable t) {

                    }
                });
            }
        });


    }
}
