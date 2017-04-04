package com.hbl.sandbox1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BannersWrapper {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("bannersList")
    @Expose
    private List<Banners> banners = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Banners> getBanners() {
        return banners;
    }

    public void setBanners(List<Banners> banners) {
        this.banners.addAll(banners);
    }

}