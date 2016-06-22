package com.xebia.philadelphia.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class List implements Serializable {

    @SerializedName("dt")
    private long date;

    @SerializedName("temp")
    private Temp temp;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("weather")
    private ArrayList<Weather> weather;

    @SerializedName("speed")
    private double speed;

    @SerializedName("deg")
    private int deg;

    @SerializedName("clouds")
    private int clouds;

    @Override
    public String toString() {
        return "List{" +
                "date=" + date +
                ", temp=" + temp +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", weather=" + weather +
                ", speed=" + speed +
                ", deg=" + deg +
                ", clouds=" + clouds +
                '}';
    }

    public long getDate() {
        return date;
    }

    public Temp getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public int getClouds() {
        return clouds;
    }
}
