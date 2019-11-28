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
    TextView eId,eName,repoDate,repoQuality, textReport;
    Button justifyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_details);
       webReport = findViewById(R.id.webRepo);
        eId = findViewById(R.id.eID);
        eName = findViewById(R.id.eName);
        repoDate = findViewById(R.id.repoDate);
        repoQuality = findViewById(R.id.repoType);
        //textReport = findViewById(R.id.testReport);
        final Intent intent = getIntent();
        eId.setText(intent.getStringExtra("id"));
        eName.setText(intent.getStringExtra("eName"));
        repoQuality.setText(intent.getStringExtra("repoClassify"));
        repoDate.setText(intent.getStringExtra("repoDat"));
      //  textReport.setText();
      justifyButton  =   findViewById(R.id.justifyBtn);
       // webReport.loadUrl(intent.getStringExtra("report"));

        webReport.loadDataWithBaseURL(null,intent.getStringExtra("report"),"text/html","utf-8",null);

        justifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReportDetails.this,PerformsnceReating.class);

                intent.putExtra("empName",intent.getStringExtra("eName"));
                intent.putExtra("eId", String.valueOf(intent.getStringExtra("id")));

                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
