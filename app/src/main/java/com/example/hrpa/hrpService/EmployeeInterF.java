package com.example.hrpa.hrpService;

import com.example.hrpa.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeInterF {
    @GET("allEmployee")
    Call<List<Employee>> getAllEmployee();

}
