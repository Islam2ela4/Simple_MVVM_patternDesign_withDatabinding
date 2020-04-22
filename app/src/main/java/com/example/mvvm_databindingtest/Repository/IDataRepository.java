package com.example.mvvm_databindingtest.Repository;

import android.content.Context;

public interface IDataRepository {
    void storeData(Context context, String fname, String lname, String email);

    void loadData(Context context, DataRepository.DataCallBack dataCallBack);
}
