package com.challengeappmarceloscaccia.com.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Localizacion {

    public int id;
    public int parent_id;
    @SerializedName("name")
    public String Name;
    public String zip;
    public Double geo_lat;
    public int level;
    public double geo_lng;
    public String slug;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGeo_lng(double geo_lng) {
        this.geo_lng = geo_lng;
    }

    public Localizacion(int id, int parent_id, String name, String zip, Double geo_lat, int level, double geo_lng, String slug) {
        this.parent_id = parent_id;
        Name = name;
        this.zip = zip;
        this.geo_lat = geo_lat;
        this.level = level;
        this.geo_lng = geo_lng;
        this.slug = slug;
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Double getGeo_lat() {
        return geo_lat;
    }

    public void setGeo_lat(Double geo_lat) {
        this.geo_lat = geo_lat;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getGeo_lng() {
        return geo_lng;
    }

    public void setGeo_lng(int geo_lng) {
        this.geo_lng = geo_lng;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
