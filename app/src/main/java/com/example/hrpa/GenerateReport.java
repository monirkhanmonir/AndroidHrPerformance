package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.hrpa.Model.Employee;
import com.example.hrpa.Model.WorkReport;
import com.example.hrpa.RetrofitConnector.RetrofitClientInstance;
import com.example.hrpa.SharePreferance.HrpSharePreferance;
import com.example.hrpa.hrpService.EmployeeInterF;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenerateReport extends AppCompatActivity {
    EditText report;
    RadioGroup repoType;
    RadioButton monthly,querterly,halfyearly,yearly;
    Button saveData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_report);
        monthly  = findViewById(R.id.monthly);
        querterly = findViewById(R.id.quarterly);
        halfyearly = findViewById(R.id.halfyear);
        yearly = findViewById(R.id.yearly);
        report = findViewById(R.id.eReport);
        repoType = findViewById(R.id.repoGroup);
        saveData = findViewById(R.id.save);



        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int rpt =repoType.getCheckedRadioButtonId();
              RadioButton rdtn =   repoType.findViewById(rpt);
                Log.d("check", rdtn.getText().toString());

                String repo = report.getText().toString();
                SharedPreferences preferences = HrpSharePreferance.getSharePreferance(getApplicationContext());
                String user =preferences.getString("user","");
                Log.d("check12", user);

                EmployeeInterF service = RetrofitClientInstance.getRetrofitInstance().create(EmployeeInterF.class);
                WorkReport workReport = new WorkReport(rdtn.getText().toString(),repo);
                Call<WorkReport> call = service.storeEeReport(user,workReport);
                call.enqueue(new Callback<WorkReport>() {
                    @Override
                    public void onResponse(Call<WorkReport> call, Response<WorkReport> response) {
                        if(response.isSuccessful()){
                            report.setText("");
                            Toast.makeText(getApplicationContext(), "Report successfully generated.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Report generated fail.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<WorkReport> call, Throwable t) {

                    }
                });
            }
        });


    }
}
