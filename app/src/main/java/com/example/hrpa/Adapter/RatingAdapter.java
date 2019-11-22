package com.example.hrpa.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        TextView designation = convertView.findViewById(R.id.workquality);
        TextView score = convertView.findViewById(R.id.pointScore);

        name.setText(reatingList.get(position).getEmpName());
        designation.setText(reatingList.get(position).getJobTitle());

        score.setText(reatingList.get(position).getOverallRating().toString());

        return  convertView;
    }
}
