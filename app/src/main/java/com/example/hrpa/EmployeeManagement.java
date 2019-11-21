package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hrpa.Adapter.EmployeeAdapter;
import com.example.hrpa.Model.Employee;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.hrpService.EmployeeInterF;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeManagement extends AppCompatActivity {
  ListView listView;
    List<Employee> empList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_management);
        listView = findViewById(R.id.allEmployee);

        EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
        Call<List<Employee>> call = service.getAllEmployee();

        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                 empList = response.body();
                Log.d("Employee", empList.toString());

                EmployeeAdapter adapter= new  EmployeeAdapter(EmployeeManagement.this,empList);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(EmployeeManagement.this,EmployeeDetails.class);

                        String idhh= String.valueOf(empList.get(position).getId());

                        intent.putExtra("eId",idhh);
                        intent.putExtra("eName",empList.get(position).getEmpName());
                        intent.putExtra("empEmail",empList.get(position).getEmpEmail());
                        intent.putExtra("user", empList.get(position).getUser());
                        intent.putExtra("gender", empList.get(position).getGender());
                        intent.putExtra("jobTitle", empList.get(position).getJobTitle());
                        intent.putExtra("birthDAte", empList.get(position).getBirthDate());
                        intent.putExtra("jpinDate", empList.get(position).getJoinDate());
                        intent.putExtra("address", empList.get(position).getAddress());
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(),empList.get(position).getEmpName(),Toast.LENGTH_SHORT).show();

                    }
                });



            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });

    }
}
