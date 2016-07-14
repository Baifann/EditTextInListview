package com.baifan.listvviewandedittext;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baifan on 16/6/2.
 */
public class SecondActivity extends Activity implements View.OnClickListener {
    private ListView mLv;
    private SecondAdapter mAdapter;
    private List<News> mList = new ArrayList<>();
    private Button mBtnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEvents();
        initDatas();
    }

    private void initDatas() {
        createList();
    }

    private void initEvents() {
        mAdapter = new SecondAdapter(this);
        mLv.setAdapter(mAdapter);
        mBtnLog.setOnClickListener(this);
    }

    private void initViews() {
        mLv = (ListView) findViewById(R.id.lv);
        mBtnLog = (Button) findViewById(R.id.btn_log);
    }

    private void createList() {
        for (int i = 0; i < 20; i++) {
            News news = new News();
            news.setNum(i);
            mList.add(news);
        }
        mAdapter.setList(mList);
    }

    @Override
    public void onClick(View v) {
        Log.i("caonima", mList.toString());
    }
}
