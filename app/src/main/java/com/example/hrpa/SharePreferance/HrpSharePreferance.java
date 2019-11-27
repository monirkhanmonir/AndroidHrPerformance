package com.example.hrpa.SharePreferance;

import android.content.Context;
import android.content.SharedPreferences;

public class HrpSharePreferance {

    public static SharedPreferences getSharePreferance(Context context){
       return context.getSharedPreferences("login_info",context.MODE_PRIVATE);

    }
}
