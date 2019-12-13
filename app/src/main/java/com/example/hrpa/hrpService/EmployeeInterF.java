package com.example.hrpa.hrpService;

import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.Model.Employee;
import com.example.hrpa.Model.WorkReport;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmployeeInterF {
    @GET("allEmployee")
    Call<List<Employee>> getAllEmployee();

    @GET("performance/report")
    Call<List<EmpRating>> getEmpReating();

    @GET("empReport")
    Call<List<WorkReport>> getEmpReport();

    @GET("login/{user}/{psd}")
    Call<Employee> userLogin(@Path("user") String user,@Path("psd") String psd);

    @GET("feedback/{user}")
    Call<List<EmpRating>> getRetingByUser(@Path("user") String user);



    @POST("storeEmp")
    Call<Employee> storeEmployee(@Body Employee employee);

    @POST("storeTaring")
    Call<EmpRating> storePerformanceRating(@Body EmpRating empRating);

    @POST("workReport/{user}")
    Call<WorkReport> storeEeReport(@Path("user")String user, @Body WorkReport workReport);



}
