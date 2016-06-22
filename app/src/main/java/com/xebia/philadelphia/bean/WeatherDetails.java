package com.xebia.philadelphia.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class WeatherDetails implements Serializable{


    @SerializedName("city")
    private City city;

    @SerializedName("cod")
    private String cod;

    @SerializedName("message")
    private double message;

    @SerializedName("cnt")
    private int cnt;

    @SerializedName("list")
    private ArrayList<List> list;

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "city=" + city +
                ", cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                '}';
    }

    public City getCity() {
        return city;
    }

    public String getCod() {
        return cod;
    }

    public double getMessage() {
        return message;
    }

    public int getCnt() {
        return cnt;
    }

    public ArrayList<List> getList() {
        return list;
    }
}
