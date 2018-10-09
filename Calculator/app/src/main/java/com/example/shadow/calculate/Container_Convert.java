package com.example.shadow.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Container_Convert extends AppCompatActivity {

    EditText editText_bit;
    TextView textView_bit;
    EditText editText_byte;
    TextView textView_byte;
    EditText editText_kb;
    TextView textView_kb;
    EditText editText_mb;
    TextView textView_mb;
    EditText editText_gb;
    TextView textView_gb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container__convert);

        editText_bit=(EditText)findViewById(R.id.editText_bit);
        textView_bit=(TextView)findViewById(R.id.textView_bit);
        editText_byte=(EditText)findViewById(R.id.editText_byte);
        textView_byte=(TextView)findViewById(R.id.textView_byte);
        editText_kb=(EditText)findViewById(R.id.editText_kb);
        textView_kb=(TextView)findViewById(R.id.textView_kb);
        editText_mb=(EditText)findViewById(R.id.editText_mb);
        textView_mb=(TextView)findViewById(R.id.textView_mb);
        editText_gb=(EditText)findViewById(R.id.editText_gb);
        textView_gb=(TextView)findViewById(R.id.textView_gb);

        Button button_bit=(Button)findViewById(R.id.button_bit);
        button_bit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bit=Double.valueOf(editText_bit.getText().toString());
                textView_byte.setText(String.valueOf(bit*0.125));
                textView_kb.setText(String.valueOf(bit*0.000121));
                textView_mb.setText(String.valueOf(bit*0.00000011921));
                textView_gb.setText(String.valueOf(bit*0.00000000011642));
            }
        });
        Button button_byte=(Button)findViewById(R.id.button_byte);
        button_byte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double b=Double.valueOf(editText_byte.getText().toString());
                textView_bit.setText(String.valueOf(b*8));
                textView_kb.setText(String.valueOf(b*0.0009766));
                textView_mb.setText(String.valueOf(b*0.00000095367));
                textView_gb.setText(String.valueOf(b*0.00000000093121));
            }
        });
        Button button_kb=(Button)findViewById(R.id.button_kb);
        button_kb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kb=Double.valueOf(editText_kb.getText().toString());
                textView_bit.setText(String.valueOf(kb*8192));
                textView_byte.setText(String.valueOf(kb*1024));
                textView_mb.setText(String.valueOf(kb*0.0009766));
                textView_gb.setText(String.valueOf(kb*0.00000095367));
            }
        });
        Button button_mb=(Button)findViewById(R.id.button_mb);
        button_mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double mb=Double.valueOf(editText_mb.getText().toString());
                textView_bit.setText(String.valueOf(mb*8388608));
                textView_byte.setText(String.valueOf(mb*1048576));
                textView_kb.setText(String.valueOf(mb*1024));
                textView_gb.setText(String.valueOf(mb*0.0009766));
            }
        });
        Button button_gb=(Button)findViewById(R.id.button_gb);
        button_gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double  gb=Double.valueOf(editText_gb.getText().toString());
                //textView_bit.setText(String.valueOf(gb*8589934592));
                textView_byte.setText(String.valueOf(gb*1073741824));
                textView_kb.setText(String.valueOf(gb*1048576));
                textView_mb.setText(String.valueOf(gb*1024));
            }
        });

    }
}
