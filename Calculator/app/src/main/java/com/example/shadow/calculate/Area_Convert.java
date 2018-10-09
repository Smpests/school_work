package com.example.shadow.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Area_Convert extends AppCompatActivity {
    EditText editText_square;
    TextView textView_square;
    EditText editText_square_km;
    TextView textView_square_km;
    EditText editText_gm;
    TextView textView_gm;
    EditText editText_gq;
    TextView textView_gq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area__convert);

        editText_square=(EditText)findViewById(R.id.editText_square);
        textView_square=(TextView)findViewById(R.id.textView_square);
        editText_square_km=(EditText)findViewById(R.id.editText_square_km);
        textView_square_km=(TextView)findViewById(R.id.textView_square_km);
        editText_gm=(EditText)findViewById(R.id.editText_gm);
        textView_gm=(TextView)findViewById(R.id.textView_gm);
        editText_gq=(EditText)findViewById(R.id.editText_gq);
        textView_gq=(TextView)findViewById(R.id.textView_gq);

        Button button_square=(Button)findViewById(R.id.button_square);
        button_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double square=Double.valueOf(editText_square.getText().toString());
                textView_square_km.setText(String.valueOf(square/1000000));
                textView_gm.setText(String.valueOf(square/100));
                textView_gq.setText(String.valueOf(square/10000));
            }
        });
        Button button_square_km=(Button)findViewById(R.id.button_square_km);
        button_square_km.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double square_km=Double.valueOf(editText_square_km.getText().toString());
                textView_square.setText(String.valueOf(square_km*1000000));
                textView_gm.setText(String.valueOf(square_km*10000));
                textView_gq.setText(String.valueOf(square_km*100));
            }
        });
        Button button_gm=(Button)findViewById(R.id.button_gm);
        button_gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double gm=Double.valueOf(editText_gm.getText().toString());
                textView_square.setText(String.valueOf(gm*100));
                textView_square_km.setText(String.valueOf(gm/10000));
                textView_gq.setText(String.valueOf(gm/100));
            }
        });
        Button button_gq=(Button)findViewById(R.id.button_gq);
        button_gq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double gq=Double.valueOf(editText_gq.getText().toString());
                textView_square.setText(String.valueOf(gq*10000));
                textView_square_km.setText(String.valueOf(gq/100));
                textView_gm.setText(String.valueOf(gq*100));
            }
        });


    }
}
