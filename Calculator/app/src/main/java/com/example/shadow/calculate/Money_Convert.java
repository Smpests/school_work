package com.example.shadow.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Money_Convert extends AppCompatActivity {
    EditText editText_yuan;
    TextView textView_yuan;
    EditText editText_dollar;
    TextView textView_dollar;
    EditText editText_ry;
    TextView textView_ry;
    EditText editText_oy;
    TextView textView_oy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money__convert);

        editText_yuan=(EditText)findViewById(R.id.editText_yuan);
        textView_yuan=(TextView)findViewById(R.id.textView_yuan);
        editText_dollar=(EditText)findViewById(R.id.editText_dollar);
        textView_dollar=(TextView)findViewById(R.id.textView_dollar);
        editText_ry=(EditText)findViewById(R.id.editText_ry);
        textView_ry=(TextView)findViewById(R.id.textView_ry);
        editText_oy=(EditText)findViewById(R.id.editText_oy);
        textView_oy=(TextView)findViewById(R.id.textView_oy);

        Button button_yuan=(Button)findViewById(R.id.button_yuan);
        button_yuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double yuan=Double.valueOf(editText_yuan.getText().toString());
                textView_dollar.setText(String.valueOf(yuan*0.1513));
                textView_ry.setText(String.valueOf(yuan*16.9773));
                textView_oy.setText(String.valueOf(yuan*0.1286));
            }
        });
        Button button_dollar=(Button)findViewById(R.id.button_dollar);
        button_dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dollar=Double.valueOf(editText_dollar.getText().toString());
                textView_yuan.setText(String.valueOf(dollar*6.6094));
                textView_ry.setText(String.valueOf(dollar*112.21));
                textView_oy.setText(String.valueOf(dollar*0.8497));
            }
        });
        Button button_ry=(Button)findViewById(R.id.button_ry);
        button_ry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ry=Double.valueOf(editText_ry.getText().toString());
                textView_yuan.setText(String.valueOf(ry*0.0589));
                textView_dollar.setText(String.valueOf(ry*0.008912));
                textView_oy.setText(String.valueOf(ry*0.007573));
            }
        });
        Button button_oy=(Button)findViewById(R.id.button_oy);
        button_oy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double oy=Double.valueOf(editText_oy.getText().toString());
                textView_yuan.setText(String.valueOf(oy*7.7796));
                textView_dollar.setText(String.valueOf(oy*1.176));
                textView_ry.setText(String.valueOf(oy*132.053));
            }
        });
    }
}
