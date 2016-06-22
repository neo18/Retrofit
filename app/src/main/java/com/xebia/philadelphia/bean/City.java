package com.xebia.philadelphia.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Naveen Rawat on 04-05-2016.
 */
public class City implements Serializable {

    @SerializedName("id")
    private double id;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    @SerializedName("population")
    private double population;

    @SerializedName("coord")
    private Coord coord;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", coord=" + coord +
                '}';
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getPopulation() {
        return population;
    }

    public Coord getCoord() {
        return coord;
    }
}
