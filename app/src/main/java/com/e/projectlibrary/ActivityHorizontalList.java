package com.e.projectlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.location.Address;
import android.os.Bundle;

import com.e.projectlibrary.Adapter.AdapterList;
import com.e.projectlibrary.Model.Dataclass;
import com.e.projectlibrary.Model.ModelList;
import com.e.projectlibrary.databinding.ActivityHorizontalListBinding;

import java.util.ArrayList;
import java.util.List;

public class ActivityHorizontalList extends AppCompatActivity {
    private Context context;
    private AdapterList adapterList;
    private List<ModelList> list;
    LinearLayoutManager layoutManager,layoutManagerVertical;
    ActivityHorizontalListBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_horizontal_list);
        context=this;
        initView();

    }

    private void initView() {
     list=new ArrayList<>();
        for(int i=0;i<=10;i++){
            list.add(new ModelList("vivek","shahjadpur"));
        }
      layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        binding.recycleList.setLayoutManager(layoutManager);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.recycleList);
        adapterList=new AdapterList(list,context);
        binding.recycleList.setAdapter(adapterList);
    }
}