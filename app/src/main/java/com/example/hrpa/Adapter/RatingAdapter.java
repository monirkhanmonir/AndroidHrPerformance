package com.example.hrpa.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hrpa.Model.EmpRating;
import com.example.hrpa.R;

import java.util.List;

public class RatingAdapter extends ArrayAdapter<EmpRating> {
    Context context;
    List<EmpRating> reatingList;

    public RatingAdapter(@NonNull Context context,  List<EmpRating> retingList) {
        super(context, R.layout.emp_performance_report,retingList);
        this.context = context;
        this.reatingList = retingList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.emp_performance_report,parent,false);

        TextView name = convertView.findViewById(R.id.empName);
        RatingBar overAllScore = convertView.findViewById(R.id.overallRating);
        TextView overallCmnt = convertView.findViewById(R.id.additionalCmnt);

        float total = Float.parseFloat(reatingList.get(position).getOverallRating());
        float viewScore=0;
        if(total>=0 && total<=5){
            viewScore = 1;
        }else if(total>5 && total<=10){
            viewScore = 2;
        }else if(total>10 && total<=15){
            viewScore = 3;
        }else if(total>15 && total<=20){
            viewScore = 4;
        }else if(total>20 && total<=25){
            viewScore = 5;
        }
        name.setText(reatingList.get(position).getEmpName());
        overAllScore.setRating(viewScore);
        overallCmnt.setText(reatingList.get(position).getAdditionalCmnt());



     //   score.setText(reatingList.get(position).getOverallRating().toString());

        return  convertView;
    }
}
