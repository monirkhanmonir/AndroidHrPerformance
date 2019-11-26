package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hrpa.Adapter.WorkReportAdapter;
import com.example.hrpa.Model.Employee;
import com.example.hrpa.Model.WorkReport;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.hrpService.EmployeeInterF;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppraisalRating extends AppCompatActivity {
    List<WorkReport> repoList = new ArrayList<>();
    ListView repoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appraisal_rating);
        repoView = findViewById(R.id.reportView);
        EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
        Call<List<WorkReport>> call = service.getEmpReport();
        call.enqueue(new Callback<List<WorkReport>>() {
            @Override
            public void onResponse(Call<List<WorkReport>> call, Response<List<WorkReport>> response) {
                repoList = response.body();
                Log.d("EmpReport", repoList.toString());

                WorkReportAdapter adapter = new WorkReportAdapter(AppraisalRating.this, repoList);
                repoView.setAdapter(adapter);

                repoView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(AppraisalRating.this, ReportDetails.class);

                        intent.putExtra("eName", repoList.get(position).getEmpName());
                        intent.putExtra("id", String.valueOf(repoList.get(position).getEmpId()));
                        intent.putExtra("repoClassify", repoList.get(position).getRepoDuration());
                        intent.putExtra("repoDat", repoList.get(position).getReopDate());
                        intent.putExtra("report", repoList.get(position).getWorkReport());

                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<List<WorkReport>> call, Throwable t) {

            }
        });
    }
}
