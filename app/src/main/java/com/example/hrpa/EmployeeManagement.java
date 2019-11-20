package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeManagement extends AppCompatActivity {
  ListView listView;
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
                final List<Employee> empList = response.body();
                Log.d("Employee", empList.toString());

               // EmployeeAdapter adapter= new  EmployeeAdapter(this,empList);
              //  listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String name = empList.get(position).getEmpName();
                        Toast.makeText(EmployeeManagement.this,name,Toast.LENGTH_SHORT).show();
                    }
                });



            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {

            }
        });

    }
}
