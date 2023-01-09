package com.eren.emlakcepteservice.request;

import com.eren.emlakcepteservice.entity.enums.RealtyType;

public class RealtyUpdateRequest {

    private String title;
    private String province;
    private String district;
    private RealtyType type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public RealtyType getType() {
        return type;
    }

    public void setType(RealtyType type) {
        this.type = type;
    }
}
