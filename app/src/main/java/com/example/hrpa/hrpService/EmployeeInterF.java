package com.example.hrpa.hrpService;

import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.Model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EmployeeInterF {
    @GET("allEmployee")
    Call<List<Employee>> getAllEmployee();

    @GET("performance/report")
    Call<List<EmpRating>> getEmpReating();


    @POST("storeEmp")
    Call<Employee> storeEmployee(@Body Employee employee);

}
