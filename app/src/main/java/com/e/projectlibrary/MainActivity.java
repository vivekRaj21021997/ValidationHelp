package com.e.projectlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.hrvalidationhelper.HRValidationHelper;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText email;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btn=findViewById(R.id.btn);
        email=findViewById(R.id.email);
        HRValidationHelper.setDisableEmojiInTitle(email);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*
                if(HRValidationHelper.isValidEmail(email.getText().toString())){
                    Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"Not valid email",Toast.LENGTH_SHORT).show();
                }*/

            }
        });
    }
}