package com.example.hrpa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReportDetails extends AppCompatActivity {
    WebView webReport;
    TextView eId, eName, repoDate, repoQuality, textReport;
    Button justifyButton;
    String name,id,repoType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);
        webReport = findViewById(R.id.webRepo);
        eId = findViewById(R.id.eID);
        eName = findViewById(R.id.eName);
        repoDate = findViewById(R.id.repoDate);
        repoQuality = findViewById(R.id.repoQuality);
        //textReport = findViewById(R.id.testReport);
        Intent intent = getIntent();
        name = intent.getStringExtra("eName");
        id = intent.getStringExtra("id");
        repoType = intent.getStringExtra("repoClassify");
        eId.setText(id);
        eName.setText(name);

        repoQuality.setText(repoType);
       // repoDate.setText();
        //  textReport.setText();
        justifyButton = findViewById(R.id.justifyBtn);
        // webReport.loadUrl(intent.getStringExtra("report"));

        webReport.loadDataWithBaseURL(null, intent.getStringExtra("report"), "text/html", "utf-8", null);

        justifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportDetails.this, PerformsnceReating.class);

                intent.putExtra("empName", name);
                intent.putExtra("eId",id);
                intent.putExtra("repoType",repoType);
               // intent.putExtra("jobTitle",)
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
