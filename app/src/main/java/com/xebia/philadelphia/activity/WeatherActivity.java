package com.xebia.philadelphia.activity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.xebia.philadelphia.R;
import com.xebia.philadelphia.adapters.WeatherAdapter;
import com.xebia.philadelphia.bean.WeatherDetails;
import com.xebia.philadelphia.network.NetworkTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class WeatherActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private WeatherDetails mWeatherDetails;
    private WeatherAdapter mWeatherAdapter;
    private int width;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        width = displaymetrics.widthPixels;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mListView = (ListView) findViewById(R.id.list);
        if (mListView != null) {
            mListView.setOnItemClickListener(this);
        }
        getWeatherData();
    }

    private void getWeatherData() {

        showDialog();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org")
                .build();
        NetworkTask task = retrofit.create(NetworkTask.class);
        Call<WeatherDetails> call = task.getDetails();
        call.enqueue(new Callback<WeatherDetails>() {
            @Override
            public void onResponse(Call<WeatherDetails> call, Response<WeatherDetails> response) {
                dismissDialog();
                if (response.isSuccessful()) {
                    mWeatherDetails = response.body();
                    mWeatherAdapter = new WeatherAdapter(WeatherActivity.this, mWeatherDetails, width);
                    mListView.setAdapter(mWeatherAdapter);
                }
            }

            @Override
            public void onFailure(Call<WeatherDetails> call, Throwable t) {
                dismissDialog();
                t.printStackTrace();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("data", mWeatherDetails.getList().get(position));
        goWithBundle(DetailActivity.class, bundle);

    }
}
