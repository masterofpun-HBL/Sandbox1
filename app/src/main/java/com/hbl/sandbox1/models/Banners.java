package com.hbl.sandbox1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banners {

    @SerializedName("0")
    @Expose
    private String _0;
    private int _0_num;
    @SerializedName("entity_id")
    @Expose
    private String entityId;
    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("sku")
    @Expose
    private String sku;

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
        this._0_num = Integer.parseInt(_0);
    }

    public int get0_num() {
        return _0_num;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}