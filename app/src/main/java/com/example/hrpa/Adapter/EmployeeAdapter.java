package com.example.hrpa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hrpa.Model.Employee;
import com.example.hrpa.R;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    Context context;
    List<Employee> empList;

    public EmployeeAdapter(Context context, List<Employee> empList){
        super(context, R.layout.all_employee, empList);
        this.context  = context;
        this.empList = empList;

    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.all_employee,parent,false);
        TextView empName = convertView.findViewById(R.id.repoQuality);
        TextView designation = convertView.findViewById(R.id.workquality);
        TextView empEmail = convertView.findViewById(R.id.workqualitycmnt);


        empName.setText(empList.get(position).getEmpName());
        empEmail.setText(empList.get(position).getEmpEmail());
        designation.setText(empList.get(position).getJobTitle());


        return convertView;
    }
}
