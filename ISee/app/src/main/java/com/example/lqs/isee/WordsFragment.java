package com.example.lqs.isee;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lqs on 2017/11/17.
 */

public class WordsFragment extends Fragment {
    private MyDBManager myDBManager;
    private ListView mListView;
    private String words;
    private Button searchButton;
    private EditText searchText;
    private List<Map<String,String>> mList;
    private SimpleAdapter adapter;
    private int once = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_words,container,false);
        mListView = (ListView) view.findViewById(R.id.mWordView);
        searchButton = (Button) view.findViewById(R.id.searchButton);
        searchText = (EditText) view.findViewById(R.id.searchText);
        myDBManager = new MyDBManager(getContext());
        mList = new ArrayList<>();
        initList();
        final SimpleAdapter mAdapter = new SimpleAdapter(getContext(),mList,R.layout.list_words,
                new String[] {"word","translate"},
                new int[] {R.id.word,R.id.wordTranslate});
        adapter = mAdapter;
        mListView.setAdapter(mAdapter);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (once == 0) {
                    searchText.setVisibility(View.VISIBLE);
                    once = 1;
                }  else {
                    searchText.setVisibility(View.INVISIBLE);
                    once = 0;
                }
            }
        });
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if (s.toString().equals("")) {
                        refreshList();
                    } else {
                        refreshList1(s.toString());
                    }
                } catch (Exception e) {
                    Toast.makeText(getContext(),"未收藏",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final LayoutInflater factory = LayoutInflater.from(getContext());
                final View  myLoginView = factory.inflate(R.layout.function_layout,null);
                final AlertDialog.Builder myBulider = new AlertDialog.Builder(getContext());
                final AlertDialog dialog;
                myBulider.setView(myLoginView);
                dialog = myBulider.show();
                Button deleteButton = (Button) myLoginView.findViewById(R.id.deleteBt);
                deleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDBManager.execWrite("delete from words2 where word = '" + mList.get(position).get("word") + "'");
                        dialog.dismiss();
                        refreshList();
                    }
                });
                return true;
            }
        });
        return view;
    }

    public void initList() {
        mList.clear();
        words = myDBManager.execRead("SELECT * FROM words2");
        String word[] = words.split("#");
        for (int i = 0;i < word.length;i++) {
            Map<String,String> map = new HashMap<>();
            String str[] = word[i].split("/");
            map.put("word", str[0]);
            map.put("translate", str[1]);
            mList.add(map);
        }
    }

    public void initList(String queryStr){
        mList.clear();
        words = myDBManager.execRead("select * from words2 where word like '" + queryStr + "%'");
        String word[] = words.split("#");
        for (int i = 0;i < word.length;i++) {
            Map<String, String> map = new HashMap<>();
            String str[] = word[i].split("/");
            map.put("word", str[0]);
            map.put("translate", str[1]);
            mList.add(map);
        }
    }

    public void refreshList() {
        initList();
        adapter.notifyDataSetChanged();
    }
    public void refreshList1(String str) {
        initList(str);
        adapter.notifyDataSetChanged();
    }
}
