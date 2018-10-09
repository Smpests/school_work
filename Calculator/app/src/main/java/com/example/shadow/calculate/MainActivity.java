package com.example.shadow.calculate;


import java.util.Arrays;

import bsh.EvalError;
import bsh.Interpreter;     //java动态执行代码

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
/*通过建立一个BeanShell解释器，使用eval()或source()命令，你可以在你的应用程序中求文本表达式的值和运行脚本*/
//继承自AppCompatActivity,否则不会显示顶部菜单栏；
public class MainActivity extends AppCompatActivity implements OnClickListener{

    EditText rsText = null;  //显示器
    boolean isClear = false; //用于记录依稀
    private DrawerLayout mDrawerLayout;
    //item 菜单


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.cal_jinzhi);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.cal_jinzhi:
                        Intent intent=new Intent(MainActivity.this,JinZhiActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.cal_danwei:
                        Intent intent1=new Intent(MainActivity.this,ConvertActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.cal_function:
                        Intent intent2=new Intent(MainActivity.this,FunctionActivity.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });


        //fun 功能按钮
        rsText = (EditText)findViewById(R.id.rsText);
        Button btnDel = (Button)findViewById(R.id.delete);
        Button btnPlu = (Button)findViewById(R.id.plus);
        Button btnMin = (Button)findViewById(R.id.minus);
        Button btnMul = (Button)findViewById(R.id.multiply);
        Button btnDiv = (Button)findViewById(R.id.division);
        Button btnEqu = (Button)findViewById(R.id.equ);
        Button btnTono = (Button)findViewById(R.id.tonone);
        Button btnLeft = (Button)findViewById(R.id.left);
        Button btnRight = (Button)findViewById(R.id.right);

        //num 数字按钮
        Button num0 = (Button)findViewById(R.id.num0);
        Button num1 = (Button)findViewById(R.id.num1);
        Button num2 = (Button)findViewById(R.id.num2);
        Button num3 = (Button)findViewById(R.id.num3);
        Button num4 = (Button)findViewById(R.id.num4);
        Button num5 = (Button)findViewById(R.id.num5);
        Button num6 = (Button)findViewById(R.id.num6);
        Button num7 = (Button)findViewById(R.id.num7);
        Button num8 = (Button)findViewById(R.id.num8);
        Button num9 = (Button)findViewById(R.id.num9);
        Button dot = (Button)findViewById(R.id.dot);

        //listener
        btnTono.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnPlu.setOnClickListener(this);
        btnMin.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnEqu.setOnClickListener(this);
        num0.setOnClickListener(this);
        num1.setOnClickListener(this);
        num2.setOnClickListener(this);
        num3.setOnClickListener(this);
        num4.setOnClickListener(this);
        num5.setOnClickListener(this);
        num6.setOnClickListener(this);
        num7.setOnClickListener(this);
        num8.setOnClickListener(this);
        num9.setOnClickListener(this);
        dot.setOnClickListener(this);
    }

    @Override
    public void onClick(View e) {
        Button btn = (Button)e;
        String exp = rsText.getText().toString();
        if(isClear &&(
                btn.getText().equals("0")
                        ||btn.getText().equals("1")
                        ||btn.getText().equals("2")
                        ||btn.getText().equals("3")
                        ||btn.getText().equals("4")
                        ||btn.getText().equals("5")
                        ||btn.getText().equals("6")
                        ||btn.getText().equals("7")
                        ||btn.getText().equals("8")
                        ||btn.getText().equals("9")
                        ||btn.getText().equals("."))
                ||btn.getText().equals("算数公式错误")){
            rsText.setText("");
            isClear = false;
        }
        if(btn.getText().equals("C")){
            rsText.setText("");
        }else if(btn.getText().equals("清除")){
            if(exp==null || exp.trim().length()==0)
                return;
            else
                rsText.setText(exp.substring(0, exp.length()-1));       /*截取字符*/
        }else if(btn.getText().equals("=")){
            if(exp==null || exp.trim().length()==0)
                return;
            exp = exp.replaceAll("×", "*"); //将所有x换成*
            exp = exp.replaceAll("÷", "/");
            exp = getRs(exp);
            if(exp.endsWith(".0")){
                exp = exp.substring(0, exp.indexOf(".0"));
            }
            rsText.setText(exp);
            isClear = false;
        }else{
            rsText.setText(rsText.getText()+""+btn.getText());
            isClear = false;
        }
        //按键完成后始终保持光标在最后一位
        rsText.setSelection(rsText.getText().length());
    }

    /***
     *  exp 算数表达式
     *  根据表达式返回结果
     */
    private String getRs(String exp){
        Interpreter bsh = new Interpreter();    /*java设计模式：解释器模式*/
        Number result = null;
        try {
            exp = filterExp(exp);               /*过滤器*/
            result = (Number)bsh.eval(exp);
        } catch (EvalError e) {
            e.printStackTrace();
            isClear = true;
            return "算数公式错误";
        }
        return result.doubleValue()+"";
    }


    /**
     * @param exp 算数表达式
     * @return 因为计算过程中,全程需要有小数参与.
     */
    private String filterExp(String exp) {
        String num[] = exp.split("");   //split()按一定方式分割字符串，此处是单个字符分割；
        String temp = null;
        int begin=0,end=0;
        for (int i = 1; i < num.length; i++) {
            temp = num[i];
            if(temp.matches("[+-/()*]")){
                if(temp.equals(".")) continue;  //continue结束本次循环;
                end = i - 1;
                temp = exp.substring(begin, end);
                if(temp.trim().length() > 0 && temp.indexOf(".")<0) //indexOf()检索的字符串值没有出现，则该方法返回 -1;
                    num[i-1] = num[i-1]+".0";
                begin = end + 1;
            }
        }
        return Arrays.toString(num).replaceAll("[\\[\\], ]", "");
    }



}
