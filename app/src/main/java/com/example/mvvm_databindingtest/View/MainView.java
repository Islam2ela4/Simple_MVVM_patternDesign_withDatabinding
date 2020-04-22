package com.example.mvvm_databindingtest.View;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvm_databindingtest.Model.DataModel;
import com.example.mvvm_databindingtest.R;
import com.example.mvvm_databindingtest.ViewModel.DataViewModel;
import com.example.mvvm_databindingtest.databinding.ViewMainBinding;


public class MainView extends AppCompatActivity {


    ViewMainBinding binding;
    DataViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.view_main);

        viewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        binding.setLifecycleOwner(this);

        viewModel.mutableLiveData.observe(this, new Observer<DataModel>() {
            @Override
            public void onChanged(DataModel dataModel) {
                setAll(dataModel.getF_name(), dataModel.getL_name(), dataModel.getEmail());
            }
        });

    }

    public void saveData(View view) {
        viewModel.onButtonStore(this, binding.etxtFirst.getText().toString(),
                binding.etxtLast.getText().toString(), binding.etxtEmail.getText().toString());
    }

    public void loadData(View view) {
        viewModel.onButtonLoad(this);
    }

    public void setAll(String fname, String lname, String email){
        binding.fname.setText(fname);
        binding.lname.setText(lname);
        binding.email.setText(email);
    }
}
