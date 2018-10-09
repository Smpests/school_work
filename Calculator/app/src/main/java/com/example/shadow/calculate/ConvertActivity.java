package com.example.shadow.calculate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ConvertActivity extends AppCompatActivity {
    /*质量*/
    EditText editText_kg;
    TextView textView_kg;
    EditText editText_g;
    TextView textView_g;
    EditText editText_t;
    TextView textView_t;
    EditText editText_kl;
    TextView textView_kl;
    /*长度*/

    /*面积*/

    /*汇率*/
    /*容量*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        /*质量*/
        editText_kg=(EditText)findViewById(R.id.editText_kg);
        textView_kg=(TextView)findViewById(R.id.textView_kg);
        editText_g=(EditText)findViewById(R.id.editText_g);
        textView_g=(TextView)findViewById(R.id.textView_g);
        editText_t=(EditText)findViewById(R.id.editText_t);
        textView_t=(TextView)findViewById(R.id.textView_t);
        editText_kl=(EditText)findViewById(R.id.editText_kl);
        textView_kl=(TextView)findViewById(R.id.textView_kl);
        /*长度*/

        /*面积*/
        /*汇率*/
        /*容量*/
        /*千克的转化*/
        Button button_kg=(Button)findViewById(R.id.button_kg);
        button_kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kg=Double.valueOf(editText_kg.getText().toString());
                textView_g.setText(String.valueOf(kg*1000));
                textView_t.setText(String.valueOf(kg/1000));
                textView_kl.setText(String.valueOf(kg*5000));
            }
        });
        Button button_g=(Button)findViewById(R.id.button_g);
        button_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double g=Double.valueOf(editText_g.getText().toString());
                textView_kg.setText(String.valueOf(g/1000));
                textView_t.setText(String.valueOf(g/1000000));
                textView_kl.setText(String.valueOf(g*5));
            }
        });
        Button button_t=(Button)findViewById(R.id.button_t);
        button_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double t=Double.valueOf(editText_t.getText().toString());
                textView_g.setText(String.valueOf(t*1000000));
                textView_kg.setText(String.valueOf(t*1000));
                textView_kl.setText(String.valueOf(t*5000000));
            }
        });
        Button button_kl=(Button)findViewById(R.id.button_kl);
        button_kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kl=Double.valueOf(editText_kl.getText().toString());
                textView_g.setText(String.valueOf(kl/5));
                textView_kg.setText(String.valueOf(kl/5000));
                textView_t.setText(String.valueOf(kl/5000000));
            }
        });

        /*面积的转化*/
        /*货币汇率的转化*/
        /*容量的转化*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.length_item:
                Intent intent1=new Intent(this,Length_Convert.class);
                startActivity(intent1);
                break;
            case R.id.area_item:
                Intent intent2=new Intent(this,Area_Convert.class);
                startActivity(intent2);
                break;
            case R.id.money_item:
                Intent intent3=new Intent(this,Money_Convert.class);
                startActivity(intent3);
                break;
            case R.id.container_item:
                Intent intent4=new Intent(this,Container_Convert.class);
                startActivity(intent4);
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.convert_select,menu);
        return true;
    }


}

