package com.example.shadow.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FunctionActivity extends AppCompatActivity {
    /*private String editText_sin_string;
    private double editText_sin_double;
    private double res_sin;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        Button button_sin=(Button)findViewById(R.id.button_sin);
        final EditText editText_sin=(EditText)findViewById(R.id.EditText_sin);
        final TextView text_view_res1=(TextView)findViewById(R.id.text_view_res1);
        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*editText_sin_string =editText_sin.getText().toString();
                editText_sin_double=Double.parseDouble(editText_sin_string);
                res_sin=Math.sin(editText_sin_double);*/
                text_view_res1.setText(String.valueOf(Math.sin(Double.parseDouble(editText_sin.getText().toString()))));

            }
        });


        Button button_cos=(Button)findViewById(R.id.button_cos);
        final EditText editText_cos=(EditText)findViewById(R.id.EditText_cos);
        final TextView text_view_res2=(TextView)findViewById(R.id.text_view_res2);
        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*editText_sin_string =editText_sin.getText().toString();
                editText_sin_double=Double.parseDouble(editText_sin_string);
                res_sin=Math.sin(editText_sin_double);*/
                text_view_res2.setText(String.valueOf(Math.cos(Double.parseDouble(editText_cos.getText().toString()))));

            }
        });


        Button button_tan=(Button)findViewById(R.id.button_tan);
        final EditText editText_tan=(EditText)findViewById(R.id.EditText_tan);
        final TextView text_view_res3=(TextView)findViewById(R.id.text_view_res3);
        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*editText_sin_string =editText_sin.getText().toString();
                editText_sin_double=Double.parseDouble(editText_sin_string);
                res_sin=Math.sin(editText_sin_double);*/
                text_view_res3.setText(String.valueOf(Math.tan(Double.parseDouble(editText_tan.getText().toString()))));

            }
        });


    }
}
