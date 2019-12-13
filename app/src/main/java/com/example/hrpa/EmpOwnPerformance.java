package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hrpa.Adapter.EmpOwnRatingAdapter;
import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.Model.WorkReport;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.SharePreferance.HrpSharePreferance;
import com.example.hrpa.hrpService.EmployeeInterF;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmpOwnPerformance extends AppCompatActivity {
    ListView performView;
    List<EmpRating> ratingList = new ArrayList<>();
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_own_performance);
       performView =  findViewById(R.id.ownPerView);



        SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
        String user =preferences.getString("user","");
        Log.d("check12", user);

        EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
        Call<List<EmpRating>> call = service.getRetingByUser(user);
        call.enqueue(new Callback<List<EmpRating>>() {
            @Override
            public void onResponse(Call<List<EmpRating>> call, Response<List<EmpRating>> response) {
                ratingList = response.body();
                Log.d("taring", ratingList.toString());

               EmpOwnRatingAdapter adapter = new EmpOwnRatingAdapter(EmpOwnPerformance.this,ratingList);
                performView.setAdapter(adapter);


                performView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(EmpOwnPerformance.this,OwnPerformDetails.class);
                        intent.putExtra("empName",ratingList.get(position).getEmpName());
                        intent.putExtra("rateDate", ratingList.get(position).getRatingDate());
                        intent.putExtra("jobnladge", ratingList.get(position).getJobKnowledge().toString());
                        intent.putExtra("jKnoledgeCmnt",ratingList.get(position).getJobKnowledgeCmnt());
                        intent.putExtra("empworkquality",ratingList.get(position).getWorkquality().toString());
                        intent.putExtra("empworkqualityCmnt",ratingList.get(position).getWorkqualityCmnt());
                        intent.putExtra("empattendance",ratingList.get(position).getAttendance().toString());
                        intent.putExtra("empattendanceCmnt",ratingList.get(position).getAttendanceCmnt());
                        intent.putExtra("empproductivity",ratingList.get(position).getProductivity().toString());
                        intent.putExtra("empproductivityCmnt",ratingList.get(position).getProductivityCmnt());
                        intent.putExtra("empcommunicationSkills",ratingList.get(position).getCommunicationSkills()).toString();
                        intent.putExtra("empcommunicationSkillscmnt",ratingList.get(position).getProductivityCmnt());
                        intent.putExtra("empdependability",ratingList.get(position).getDependability().toString());
                        intent.putExtra("empdependabilitycmnt",ratingList.get(position).getDependabilityCmnt());


                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<EmpRating>> call, Throwable t) {

            }
        });

    }
}
