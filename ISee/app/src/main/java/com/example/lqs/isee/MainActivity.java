package com.example.lqs.isee;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private NewsFragment mNewsFragment;
    private WordsFragment mWordsFragment;
    private SlidingMenu mSlidingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNewsFragment = new NewsFragment();
        mWordsFragment = new WordsFragment();
        mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.newsFragment,mNewsFragment);
        transaction.add(R.id.wordFragment,mWordsFragment);
        transaction.commit();

        mSlidingMenu.setWordsFragment(mWordsFragment);

    }
}
