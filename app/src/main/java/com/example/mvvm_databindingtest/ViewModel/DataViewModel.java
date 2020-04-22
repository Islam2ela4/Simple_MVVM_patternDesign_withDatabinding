package com.example.mvvm_databindingtest.ViewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_databindingtest.Model.DataModel;
import com.example.mvvm_databindingtest.Repository.DataRepository;
import com.example.mvvm_databindingtest.Repository.IDataRepository;

public class DataViewModel extends ViewModel {

    IDataRepository dataRepository = new DataRepository();
    public MutableLiveData<DataModel> mutableLiveData = new MutableLiveData<>();

    public void onButtonStore(Context context, String Fname, String Lname, String Email){
        dataRepository.storeData(context, Fname, Lname, Email);
    }

    public void onButtonLoad(Context context){
        dataRepository.loadData(context, new DataRepository.DataCallBack() {
            @Override
            public void onCallBack(DataModel dataModel) {
                mutableLiveData.setValue(dataModel);
            }
        });
    }
}
