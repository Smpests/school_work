package com.example.lqs.isee;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lqs on 2017/11/17.
 */

public class NewsFragment extends Fragment {
    private WebNewsResolve webNewsResolve;
    private List<Map<String,String>> mList;
    private ListView mListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.layout_news,container,false);
        mListView = (ListView) view.findViewById(R.id.mNewsView);
        mList = new ArrayList<>();
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        initList();
                        SimpleAdapter mAdapter = new SimpleAdapter(getContext(),mList,
                                R.layout.list_news,new String[] {"content"},
                                new int[] {R.id.mNewsContent});
                        mListView.setAdapter(mAdapter);
                        break;
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                webNewsResolve = new WebNewsResolve("https://www.techmeme.com/");
                mHandler.sendEmptyMessage(0);
            }
        }).start();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public List<Map<String,String>> initList() {
        for (int i = 0;i < webNewsResolve.getNewsText().size();i++) {
            Map<String,String> map = new HashMap<>();
            //Map<String,Drawable> map1 = new HashMap<>();
            map.put("content","      " + webNewsResolve.getNewsText().get(i));
            //Drawable drawable = LoadImageFromWebOperations(webNewsResolve.getNewsImage().get(i));
            //map1.put("img",drawable);

            mList.add(map);
            //mList.add(map1);
        }
        return mList;
    }
//    private Drawable LoadImageFromWebOperations(String url)
//    {
//        try
//        {
//            InputStream is = (InputStream) new URL(url).getContent();
//            return Drawable.createFromStream(is, "src name");
//        }catch (Exception e) {
//            System.out.println("Exc="+e);
//            return null;
//        }
//    }
}
