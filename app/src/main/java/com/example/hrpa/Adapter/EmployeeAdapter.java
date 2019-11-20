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

    public EmployeeAdapter(Context context, List<Employee> employees){
        super(context, R.layout.all_employee);
        this.context  = context;
        this.empList = employees;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.all_employee,parent,false);
        TextView empName = convertView.findViewById(R.id.empName);
        TextView designation = convertView.findViewById(R.id.empDesignation);
        TextView empEmail = convertView.findViewById(R.id.empEmail);


        empName.setText(empList.get(position).getEmpName());
        empEmail.setText(empList.get(position).getEmpEmail());
        designation.setText(empList.get(position).getJobTitle());


        return super.getView(position, convertView, parent);
    }
}
