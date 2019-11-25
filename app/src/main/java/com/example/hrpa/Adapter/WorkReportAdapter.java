package com.example.hrpa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hrpa.Model.WorkReport;
import com.example.hrpa.R;

import java.util.List;

public class WorkReportAdapter extends ArrayAdapter<WorkReport> {
    Context context;
    List<WorkReport> reportList;


    public WorkReportAdapter(Context context, List<WorkReport> repoList) {
        super(context, R.layout.custome_report, repoList);
        this.context = context;
        this.reportList = repoList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custome_report, parent, false);
        TextView id = convertView.findViewById(R.id.eID);
        TextView name = convertView.findViewById(R.id.eName);
        TextView date = convertView.findViewById(R.id.empDate);
        TextView repoType = convertView.findViewById(R.id.repoType);

       // id.setText(reportList.get(position).getId());
        name.setText(reportList.get(position).getEmpName());
        date.setText(reportList.get(position).getReopDate());
        repoType.setText(reportList.get(position).getRepoDuration());
        return convertView;
    }
}
