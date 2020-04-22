package com.example.mvvm_databindingtest.Repository;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mvvm_databindingtest.Model.DataModel;

public class DataRepository implements IDataRepository {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void storeData(Context context, String fname, String lname, String email){
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("Fname", fname);
        editor.putString("Lname", lname);
        editor.putString("Email", email);
        editor.commit();
    }

    @Override
    public void loadData(Context context, DataCallBack dataCallBack){
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        String fname = sharedPreferences.getString("Fname", null);
        String lname = sharedPreferences.getString("Lname", null);
        String email = sharedPreferences.getString("Email", null);
        DataModel model = new DataModel();
        model.setF_name(fname);
        model.setL_name(lname);
        model.setEmail(email);
        dataCallBack.onCallBack(model);
    }

    public interface DataCallBack{
        void onCallBack(DataModel dataModel);
    }
}