package com.e.projectlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.e.hrvalidationhelper.HRValidationHelper;
import com.e.projectlibrary.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Context context;
    private String address,postalCode,emojiHide;
   private ActivityMainBinding binding;
   private String timeZone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
    context=this;

        setScreenHeightAndWidth();
        setAllValidation();
    }
    private void setAllValidation(){
        HRValidationHelper.setDisableEmojiInTitle(binding.emojiHide);
        HRValidationHelper.setNumberBeforeAfterDecimal(binding.decimalCheck,2,3);
        HRValidationHelper.setEditTextMaxLength(binding.maxLength,8);
        binding.addressText.setText(HRValidationHelper.getCompleteAddressString(context,25.6924,85.2083));
        binding.postalCode.setText(HRValidationHelper.getCurrentPostalCode(context,25.6924,85.2083));
        timeZone=HRValidationHelper.getTimezone();
        binding.location.setText(timeZone);


    }
    public  void setScreenHeightAndWidth(){
       binding.screenWidth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ActivityHorizontalList.class);
                startActivity(intent);
            }
        });

       binding.screenHeight.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,ActivityVerticalHeightCheck.class);
               startActivity(intent);
           }
       });
    }




}