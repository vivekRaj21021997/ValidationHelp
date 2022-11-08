package com.e.projectlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.e.hrvalidationhelper.HRValidationHelper;



public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText email,emoji,maxLength;
    private Context context;
    private String address,postalCode,emojiHide;
   private TextView txtAddress,postal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        context=this;
        btn=findViewById(R.id.btn);
        email=findViewById(R.id.email);
        txtAddress=findViewById(R.id.address);
        postal=findViewById(R.id.postal_code);
        emoji=findViewById(R.id.emoji_hide);
        maxLength=findViewById(R.id.max_length);
        setAllValidation();
    }



    private void setAllValidation(){
        address=HRValidationHelper.getCompleteAddressString(context,28.5355,77.3910);
        postalCode=HRValidationHelper.getCurrentPostalCode(context,25.6924,85.2083);
        HRValidationHelper.setDisableEmojiInTitle(emoji);
        HRValidationHelper.setEditTextMaxLength(maxLength,8);
        txtAddress.setText(address);
        postal.setText(postalCode);
    }

}