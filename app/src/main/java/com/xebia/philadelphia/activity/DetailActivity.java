package com.xebia.philadelphia.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.xebia.philadelphia.R;
import com.xebia.philadelphia.bean.List;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class DetailActivity extends BaseActivity {

    private List data;
    private TextView id;
    private TextView main;
    private TextView pressure;
    private TextView speed;
    private TextView degree;
    private TextView clouds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
            data = (List) bundle.getSerializable("data");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        id = (TextView) findViewById(R.id.tvId);
        main = (TextView) findViewById(R.id.tvMain);
        pressure = (TextView) findViewById(R.id.tvPressure);
        speed = (TextView) findViewById(R.id.tvSpeed);
        degree = (TextView) findViewById(R.id.tvDegree);
        clouds = (TextView) findViewById(R.id.tvCloud);

        setData();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void setData() {

        id.setText(getString(R.string.text_id, data.getWeather().get(0).getId()));
        main.setText(getString(R.string.text_main, data.getWeather().get(0).getMain()));
        pressure.setText(getString(R.string.text_pressure, data.getPressure()));
        speed.setText(getString(R.string.text_speed, data.getSpeed()));
        degree.setText(getString(R.string.text_degree, data.getDeg()));
        clouds.setText(getString(R.string.text_clouds, data.getClouds()));

    }

}
