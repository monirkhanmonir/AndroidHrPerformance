package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hrpa.Model.Employee;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.SharePreferance.HrpSharePreferance;
import com.example.hrpa.hrpService.EmployeeInterF;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity {

    private EditText userName, password;
    private Button login;

    private TextView textView;
    private int count = 4;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        textView = findViewById(R.id.textViewId);
        textView.setText("Number of Attempts remaining : 4");

        SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());

        String user = preferences.getString("userName", "");
        String name = preferences.getString("user", "");
        Log.d("check1", user);
        Log.d("check2", name);

        if (user.equals("Admin")) {
            Intent intent = new Intent(MainActivity.this, AdminMenu.class);
            startActivity(intent);
        } else if (user.equals("Manager")) {
            Intent intent = new Intent(MainActivity.this, ManagerMenu.class);
            startActivity(intent);
        } else if (user.equals("Employee")) {
            Intent intent = new Intent(MainActivity.this, EmployeeMenu.class);
            intent.putExtra("user", username);
            startActivity(intent);
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = userName.getText().toString();
                String pass = password.getText().toString();



                EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
                //Employee employee = new Employee(username,pass);
                Call<Employee> call = service.userLogin(username, pass);
                call.enqueue(new Callback<Employee>() {
                    @Override
                    public void onResponse(Call<Employee> call, Response<Employee> response) {

                        if (response.isSuccessful()) {
                            Employee employee = response.body();
                            if (employee.getJobTitle().equals("Admin")) {

                                SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                                SharedPreferences.Editor editor = preferences.edit();

                                editor.putString("userName", employee.getJobTitle());
                                editor.commit();

                                Intent intent = new Intent(MainActivity.this, AdminMenu.class);
                                startActivity(intent);
                            } else if (employee.getJobTitle().equals("Employee")) {
                                SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                                SharedPreferences.Editor editor = preferences.edit();

                                editor.putString("userName", employee.getJobTitle());
                                editor.putString("user", employee.getEmpName());
                                editor.commit();

                                Intent intent = new Intent(MainActivity.this, EmployeeMenu.class);
                                startActivity(intent);
                            } else if (employee.getJobTitle().equals("Manager")) {
                                SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                                SharedPreferences.Editor editor = preferences.edit();

                                editor.putString("userName", employee.getJobTitle());
                                editor.commit();

                                Intent intent = new Intent(MainActivity.this, ManagerMenu.class);
                                startActivity(intent);
                            } else {
                                count--;
                                textView.setText("Number of Attempts remaining : " + count);
                                if (count == 0) {
                                    login.setEnabled(false);
                                }
                            }

                            Log.d("login", employee.toString());
                            Log.d("login", "Success........");
                        } else if (!response.isSuccessful()) {
                            Log.d("login", "Fail...........");
                            Toast.makeText(getApplicationContext(), "User Name or Password is not currect", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Employee> call, Throwable t) {

                    }
                });





                /*if(username.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123")){

                    SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("userName",username);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, AdminMenu.class);
                    startActivity(intent);
                }else if(username.equalsIgnoreCase("employee") && pass.equalsIgnoreCase("123")){
                    SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("userName",username);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, EmployeeMenu.class);
                    startActivity(intent);
                }else if(username.equalsIgnoreCase("management") && pass.equalsIgnoreCase("123")){
                    SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("userName",username);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, ManagerMenu.class);
                    startActivity(intent);
                } else{
                    count--;
                    textView.setText("Number of Attempts remaining : " + count);
                    if(count == 0){
                        login.setEnabled(false);
                    }
                }*/
            }
        });

    }
}
