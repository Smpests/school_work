package com.example.lqs.isee;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

import java.security.spec.ECField;


/**
 * Created by lqs on 2017/11/20.
 */

public class MyTextView extends AppCompatTextView{
    public  static int change_signal = 1;
    private static final String APP_ID = "20171115000095469";
    private static final String SECURITY_KEY = "KS6eXBPEvDJagDbSFe7G";
    private String selectText,answer;
    private int flag;
    private MyDBManager myDBManager;
    public MyTextView(Context context) {
        super(context);
        initActionMode(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initActionMode(context);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initActionMode(context);
    }

    public void initActionMode(Context context) {
        ActionMode.Callback mCallBack = new android.view.ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                return true;
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                menu.clear();
                inflater.inflate(R.menu.actionmode,menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.translateItem:
                        flag = 0;
                        updateAnswer();
                        break;
                    case R.id.saveItem:
                        flag = 1;
                        updateAnswer();
                        break;
                    default:
                        break;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {

            }
        };
        this.setCustomSelectionActionModeCallback(mCallBack);
    }
    public String updateAnswer() {
        try {
            final TransApi api = new TransApi(APP_ID,SECURITY_KEY);
            selectText = getText().toString().substring(getSelectionStart(),getSelectionEnd());
            myDBManager = new MyDBManager(getContext());
            final Handler mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    switch (msg.what) {
                        case 0:
                            Gson gson = new Gson();
                            TranslateResponse translateResponse = gson.fromJson(answer,TranslateResponse.class);
                            answer = translateResponse.getTrans_result().get(0).getDst();
                            if (flag == 0) {

                                Toast.makeText(getContext(),answer,Toast.LENGTH_LONG).show();
                            }
                            if (flag == 1) {
                                change_signal = 1;
                                Toast.makeText(getContext(),myDBManager.execWrite("insert into words2 values('" + selectText + "','" +
                                        answer + "')")?"收藏成功":"已收藏或查询失败",Toast.LENGTH_SHORT).show();
                            }
                            change_signal = 0;
                            break;
                    }
                }
            };
            Thread mThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        answer = api.getTransResult(selectText,"auto","zh");
                        mHandler.sendEmptyMessage(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            mThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answer;
    }

    public static int getChange_signal() {
        return change_signal;
    }
}
