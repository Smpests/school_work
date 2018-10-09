package com.example.shadow.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Length_Convert extends AppCompatActivity {

    EditText editText_m;
    TextView textView_m;
    EditText editText_cm;
    TextView textView_cm;
    EditText editText_dm;
    TextView textView_dm;
    EditText editText_nm;
    TextView textView_nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length__convert);

        editText_m=(EditText)findViewById(R.id.editText_m);
        textView_m=(TextView)findViewById(R.id.textView_m);
        editText_cm=(EditText)findViewById(R.id.editText_cm);
        textView_cm=(TextView)findViewById(R.id.textView_cm);
        editText_dm=(EditText)findViewById(R.id.editText_dm);
        textView_dm=(TextView)findViewById(R.id.textView_dm);
        editText_nm=(EditText)findViewById(R.id.editText_nm);
        textView_nm=(TextView)findViewById(R.id.textView_nm);

        /*长度的转化*/
        Button button_m=(Button)findViewById(R.id.button_m);
        button_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double m=Double.valueOf(editText_m.getText().toString());
                textView_cm.setText(String.valueOf(m*100));
                textView_dm.setText(String.valueOf(m*10));
                textView_nm.setText(String.valueOf(m*1000000000));
            }
        });
        Button button_cm=(Button)findViewById(R.id.button_cm);
        button_cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double cm=Double.valueOf(editText_cm.getText().toString());
                textView_m.setText(String.valueOf(cm/100));
                textView_dm.setText(String.valueOf(cm/10));
                textView_nm.setText(String.valueOf(cm*10000000));
            }
        });
        Button button_dm=(Button)findViewById(R.id.button_dm);
        button_dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dm=Double.valueOf(editText_dm.getText().toString());
                textView_cm.setText(String.valueOf(dm*10));
                textView_m.setText(String.valueOf(dm/10));
                textView_nm.setText(String.valueOf(dm*100000000));
            }
        });
        Button button_nm=(Button)findViewById(R.id.button_nm);
        button_nm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double nm=Double.valueOf(editText_nm.getText().toString());
                textView_m.setText(String.valueOf(nm*1000000000));
                textView_dm.setText(String.valueOf(nm*100000000));
                textView_cm.setText(String.valueOf(nm*10000000));
            }
        });
    }
}
