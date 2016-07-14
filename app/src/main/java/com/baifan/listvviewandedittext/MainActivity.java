package com.baifan.listvviewandedittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView mLv;
    private MyAdapter mAdapter;
    private List<News> mList = new ArrayList<>();
    private Button mBtnLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initEvents();
        initData();
    }

    private void initViews() {
        mBtnLog = (Button) findViewById(R.id.btn_log);
        mLv = (ListView) findViewById(R.id.lv);
    }

    private void initEvents() {
        mBtnLog.setOnClickListener(this);
        mAdapter = new MyAdapter(this);
        mLv.setAdapter(mAdapter);
    }

    private void initData() {
        createList();
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
        String s = "{\"HeWeatherdataservice\":[{\"aqi\":{\"city\":{\"aqi\":\"57\",\"co\":\"1\",\"no2\":\"38\",\"o3\":\"105\",\"pm10\":\"61\",\"pm25\":\"30\",\"qlty\":\"良\",\"so2\":\"9\"}},\"basic\":{\"city\":\"上海\",\"cnty\":\"中国\",\"id\":\"CN101020100\",\"lat\":\"31.213000\",\"lon\":\"121.445000\",\"update\":{\"loc\":\"2016-07-01 18:51\",\"utc\":\"2016-07-01 10:51\"}},\"daily_forecast\":[{\"astro\":{\"sr\":\"04:53\",\"ss\":\"19:02\"},\"cond\":{\"code_d\":\"305\",\"code_n\":\"300\",\"txt_d\":\"小雨\",\"txt_n\":\"阵雨\"},\"date\":\"2016-07-01\",\"hum\":\"63\",\"pcpn\":\"10.8\",\"pop\":\"99\",\"pres\":\"1003\",\"tmp\":{\"max\":\"31\",\"min\":\"26\"},\"vis\":\"9\",\"wind\":{\"deg\":\"227\",\"dir\":\"南风\",\"sc\":\"3-4\",\"spd\":\"14\"}},{\"astro\":{\"sr\":\"04:54\",\"ss\":\"19:02\"},\"cond\":{\"code_d\":\"302\",\"code_n\":\"300\",\"txt_d\":\"雷阵雨\",\"txt_n\":\"阵雨\"},\"date\":\"2016-07-02\",\"hum\":\"90\",\"pcpn\":\"8.0\",\"pop\":\"92\",\"pres\":\"1006\",\"tmp\":{\"max\":\"32\",\"min\":\"26\"},\"vis\":\"9\",\"wind\":{\"deg\":\"90\",\"dir\":\"南风\",\"sc\":\"微风\",\"spd\":\"4\"}},{\"astro\":{\"sr\":\"04:54\",\"ss\":\"19:02\"},\"cond\":{\"code_d\":\"300\",\"code_n\":\"101\",\"txt_d\":\"阵雨\",\"txt_n\":\"多云\"},\"date\":\"2016-07-03\",\"hum\":\"76\",\"pcpn\":\"6.5\",\"pop\":\"80\",\"pres\":\"1004\",\"tmp\":{\"max\":\"33\",\"min\":\"26\"},\"vis\":\"9\",\"wind\":{\"deg\":\"221\",\"dir\":\"南风\",\"sc\":\"微风\",\"spd\":\"7\"}},{\"astro\":{\"sr\":\"04:55\",\"ss\":\"19:02\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2016-07-04\",\"hum\":\"81\",\"pcpn\":\"4.5\",\"pop\":\"74\",\"pres\":\"1006\",\"tmp\":{\"max\":\"34\",\"min\":\"27\"},\"vis\":\"5\",\"wind\":{\"deg\":\"350\",\"dir\":\"南风\",\"sc\":\"微风\",\"spd\":\"3\"}},{\"astro\":{\"sr\":\"04:55\",\"ss\":\"19:02\"},\"cond\":{\"code_d\":\"104\",\"code_n\":\"101\",\"txt_d\":\"阴\",\"txt_n\":\"多云\"},\"date\":\"2016-07-05\",\"hum\":\"93\",\"pcpn\":\"7.0\",\"pop\":\"61\",\"pres\":\"1008\",\"tmp\":{\"max\":\"35\",\"min\":\"28\"},\"vis\":\"8\",\"wind\":{\"deg\":\"188\",\"dir\":\"南风\",\"sc\":\"微风\",\"spd\":\"9\"}},{\"astro\":{\"sr\":\"04:56\",\"ss\":\"19:02\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2016-07-06\",\"hum\":\"78\",\"pcpn\":\"3.2\",\"pop\":\"58\",\"pres\":\"1009\",\"tmp\":{\"max\":\"32\",\"min\":\"27\"},\"vis\":\"10\",\"wind\":{\"deg\":\"120\",\"dir\":\"南风\",\"sc\":\"微风\",\"spd\":\"5\"}},{\"astro\":{\"sr\":\"04:56\",\"ss\":\"19:01\"},\"cond\":{\"code_d\":\"101\",\"code_n\":\"101\",\"txt_d\":\"多云\",\"txt_n\":\"多云\"},\"date\":\"2016-07-07\",\"hum\":\"76\",\"pcpn\":\"0.1\",\"pop\":\"46\",\"pres\":\"1009\",\"tmp\":{\"max\":\"34\",\"min\":\"27\"},\"vis\":\"10\",\"wind\":{\"deg\":\"64\",\"dir\":\"南风\",\"sc\":\"微风\",\"spd\":\"2\"}}],\"hourly_forecast\":[{\"date\":\"2016-07-01 19:00\",\"hum\":\"84\",\"pop\":\"94\",\"pres\":\"1004\",\"tmp\":\"29\",\"wind\":{\"deg\":\"250\",\"dir\":\"西南风\",\"sc\":\"微风\",\"spd\":\"14\"}},{\"date\":\"2016-07-01 22:00\",\"hum\":\"92\",\"pop\":\"93\",\"pres\":\"1006\",\"tmp\":\"26\",\"wind\":{\"deg\":\"289\",\"dir\":\"西北风\",\"sc\":\"微风\",\"spd\":\"10\"}}],\"now\":{\"cond\":{\"code\":\"104\",\"txt\":\"阴\"},\"fl\":\"39\",\"hum\":\"66\",\"pcpn\":\"0\",\"pres\":\"1002\",\"tmp\":\"31\",\"vis\":\"10\",\"wind\":{\"deg\":\"190\",\"dir\":\"北风\",\"sc\":\"微风\",\"spd\":\"0\"}},\"status\":\"ok\",\"suggestion\":{\"comf\":{\"brf\":\"较不舒适\",\"txt\":\"白天虽然有雨，但仍无法削弱较高气温带来的暑意，同时降雨造成湿度加大会您感到有些闷热，不很舒适。\"},\"cw\":{\"brf\":\"不宜\",\"txt\":\"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。\"},\"drsg\":{\"brf\":\"热\",\"txt\":\"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。\"},\"flu\":{\"brf\":\"少发\",\"txt\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\"},\"sport\":{\"brf\":\"较不宜\",\"txt\":\"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意选择避雨防滑地点，并携带雨具。\"},\"trav\":{\"brf\":\"一般\",\"txt\":\"有降水，稍热，微风，旅游指数一般，外出请尽量避开降雨时间，若外出，请注意防雷并携带雨具。\"},\"uv\":{\"brf\":\"中等\",\"txt\":\"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\"}}}]}";
    }
}
