package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userName, password;
    private Button login;

    private TextView textView;
    private int count = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginBtn);
        textView = findViewById(R.id.textViewId);
        textView.setText("Number of Attempts remaining : 4");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String pass = password.getText().toString();

                if(username.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("123")){

                    Intent intent = new Intent(MainActivity.this, AdminMenu.class);
                    startActivity(intent);
                }else if(username.equalsIgnoreCase("employee") && pass.equalsIgnoreCase("123")){
                    Intent intent = new Intent(MainActivity.this, EmployeeMenu.class);
                    startActivity(intent);
                }else if(username.equalsIgnoreCase("management") && pass.equalsIgnoreCase("123")){
                    Intent intent = new Intent(MainActivity.this, ManagerMenu.class);
                    startActivity(intent);
                } else{
                    count--;
                    textView.setText("Number of Attempts remaining : " + count);
                    if(count == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });

    }
}
