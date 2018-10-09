package com.example.shadow.calculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class JinZhiActivity extends AppCompatActivity {

    private EditText editText0;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jin_zhi);

        editText0=(EditText)findViewById(R.id.EditText0);
        editText1=(EditText)findViewById(R.id.EditText1);
        editText2=(EditText)findViewById(R.id.EditText2);
        editText3=(EditText)findViewById(R.id.EditText3);
        /*final TextView textView0=(TextView)findViewById(R.id.text_view_0);
        final TextView textView1=(TextView)findViewById(R.id.text_view_1);
        final TextView textView2=(TextView)findViewById(R.id.text_view_2);
        final TextView textView3=(TextView)findViewById(R.id.text_view_3);*/

        Button button_ten=(Button)findViewById(R.id.button_ten);
        button_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("JinZhiActivity","**1**");
                //10转2
                //textView1.setText(TenToTwo(editText0.getText().toString()));
                editText1.setText(TenToTwo(editText0.getText().toString()));

                //10转8
                //textView2.setText(TenToEight(editText0.getText().toString()));
                editText2.setText(TenToEight(editText0.getText().toString()));

                //10转16
                //textView3.setText(TenToSixTeen(editText0.getText().toString()));
                editText3.setText(TenToSixTeen(editText0.getText().toString()));
                Log.d("JinZhiActivity","**2**");

            }
        });

        //二进制
        Button button_two=(Button)findViewById(R.id.button_two);
        button_two.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //2转10
                //textView0.setText(TwoToTen(editText1.getText().toString()));
                editText0.setText(TwoToTen(editText1.getText().toString()));
                //2转8
                //textView2.setText(TwoToEight());
                editText2.setText(TwoToEight());
                //2转16
                //textView3.setText(TwoToSixteen());
                editText3.setText(TwoToSixteen());
            }
        });
        //十六进制
        Button button_sixteen=(Button)findViewById(R.id.button_sixteen);
        button_sixteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //16转10
                //textView0.setText(SixTeenToTen(editText3.getText().toString()));
                editText0.setText(SixTeenToTen(editText3.getText().toString()));
                //16转2
                //textView1.setText(SixTeenToTwo());
                editText1.setText(SixTeenToTwo());
                //16转8
                //textView2.setText(SixTeenToEight());
                editText2.setText(SixTeenToEight());
            }
        });
    }




    //十进制为开始
    public String TenToTwo(String string){
        Log.d("JinZhiActivity","**3**");
        int i=Integer.parseInt(string);
        Log.d("JinZhiActivity","**4**");
        return Integer.toBinaryString(i);
    }
    public String TenToEight(String string){
        int i=Integer.parseInt(string);
        return Integer.toOctalString(i);
    }
    public String TenToSixTeen(String string){
        int i=Integer.parseInt(string);
        return Integer.toHexString(i).toUpperCase();
    }

    //二进制为开始
    public String TwoToTen(String string){
        return Integer.valueOf(string,2).toString();
    }
    public String TwoToEight(){
       return TenToEight(TwoToTen(editText1.getText().toString()));
    }
    public String TwoToSixteen(){
        return TenToSixTeen(TwoToTen(editText1.getText().toString()));
    }

    //十六进制开始
    public String SixTeenToTen(String string){
        return Integer.valueOf(string,16).toString();
    }
    public String SixTeenToTwo(){
        return TenToTwo(SixTeenToTen(editText3.getText().toString()));
    }
    public String SixTeenToEight(){
        return TenToEight(SixTeenToTen(editText3.getText().toString()));
    }
}
