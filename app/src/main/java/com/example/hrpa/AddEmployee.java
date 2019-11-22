package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.hrpa.Model.Employee;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.hrpService.EmployeeInterF;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddEmployee extends AppCompatActivity {
    EditText empName,empEmail,empUser,empPsd,empAddress;
    RadioButton admin,manager,employee;
    Button store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        empName = findViewById(R.id.employeeName);
        empEmail = findViewById(R.id.employeeEmail);
        empUser = findViewById(R.id.employeeUsername);
        empPsd  = findViewById(R.id.empPsd);
        admin = findViewById(R.id.regAdmin);
        manager = findViewById(R.id.regManager);
        employee = findViewById(R.id.regEmployee);
        empAddress= findViewById(R.id.address);
        store = findViewById(R.id.storeEmp);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = empName.getText().toString();
                String email  = empEmail.getText().toString();
                String user = empUser.getText().toString();
                String psd = empPsd.getText().toString();
                String address = empAddress.getText().toString();
                String jobTitle="";
                if(admin.isChecked()){
                    jobTitle = "Admin";
                }else if(manager.isChecked()){
                    jobTitle = "manager";
                }else if(employee.isChecked()){
                    jobTitle = "employee";
                }


                Log.d("test",user);


                Employee employee = new Employee(name,email,user,psd,jobTitle,address);
                EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
                Call<Employee> call = service.storeEmployee(employee);
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {
                       if(response.isSuccessful()){
                           Log.d("test","Success......");
                       }else{
                           Log.d("test","Not Success......");
                       }
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {

                    }
                });
            }
        });

    }
}
