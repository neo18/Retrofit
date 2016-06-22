package com.xebia.philadelphia.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class Coord implements Serializable{

    @SerializedName("lon")
    private double lon;

    @SerializedName("lat")
    private double lat;

    @Override
    public String toString() {
        return "Coord{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
