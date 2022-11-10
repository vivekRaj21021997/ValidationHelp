package com.e.projectlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.e.hrvalidationhelper.HRValidationHelper;
import com.e.projectlibrary.Adapter.AdapterVerticatlList;
import com.e.projectlibrary.Model.ModelList;
import com.e.projectlibrary.databinding.ActivityVerticalHeightCheckBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityVerticalHeightCheck extends AppCompatActivity {
    private Context context;
    private ActivityVerticalHeightCheckBinding binding;
    private AdapterVerticatlList adapterList;
    private List<ModelList> list;
    LinearLayoutManager layoutManager,layoutManagerVertical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_vertical_height_check);
        context=this;
        initView();
    }

    private void initView() {
        list=new ArrayList<>();
        for(int i=0;i<=10;i++){
            list.add(new ModelList("vivek","shahjadpur"));
        }
        adapterList=new AdapterVerticatlList(list,context);
        HRValidationHelper.setScreenHeightDouble(binding.verticalList,context,0.5);
        binding.verticalList.setAdapter(adapterList);
    }

}