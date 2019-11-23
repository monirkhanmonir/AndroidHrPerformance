package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hrpa.Adapter.RatingAdapter;
import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.Model.Employee;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.hrpService.EmployeeInterF;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeAppraisal extends AppCompatActivity {

    ListView listView;
    List<EmpRating> reatingList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_appraisal);
        listView  = findViewById(R.id.reationView);
        EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
        Call<List<EmpRating>> call = service.getEmpReating();
        call.enqueue(new Callback<List<EmpRating>>() {
            @Override
            public void onResponse(Call<List<EmpRating>> call, Response<List<EmpRating>> response) {
                reatingList = response.body();
                Log.d("msg",reatingList.toString());

                RatingAdapter adapter = new  RatingAdapter(EmployeeAppraisal.this,reatingList);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(EmployeeAppraisal.this,PerformanceDetails.class);

                        intent.putExtra("empName",reatingList.get(position).getEmpName());
                        intent.putExtra("rateDate", reatingList.get(position).getRatingDate());
                        intent.putExtra("jobnladge", reatingList.get(position).getJobKnowledge().toString());
                        intent.putExtra("jKnoledgeCmnt",reatingList.get(position).getJobKnowledgeCmnt());


                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),reatingList.get(position).getEmpName(),Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<EmpRating>> call, Throwable t) {

            }
        });

    }
}
