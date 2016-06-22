package com.xebia.philadelphia.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class Temp implements Serializable{

    @SerializedName("day")
    private double day;

    @SerializedName("min")
    private double min;

    @SerializedName("max")
    private double max;

    @SerializedName("night")
    private double night;

    @SerializedName("eve")
    private double eve;

    @SerializedName("morn")
    private double morn;

    @Override
    public String toString() {
        return "Temp{" +
                "day=" + day +
                ", min=" + min +
                ", max=" + max +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }

    public double getDay() {
        return day;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getNight() {
        return night;
    }

    public double getEve() {
        return eve;
    }

    public double getMorn() {
        return morn;
    }
}
