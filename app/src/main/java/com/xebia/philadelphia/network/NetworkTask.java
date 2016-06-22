package com.xebia.philadelphia.network;

import com.xebia.philadelphia.bean.WeatherDetails;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public interface NetworkTask {

    @GET("/data/2.5/forecast/daily?q=Philadelphia&mode=json&units=metric&cnt=16&APPID=f279ee6273c82ce2e30067a8d9511fae")
    Call<WeatherDetails> getDetails();
}
