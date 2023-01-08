package com.eren.emlakcepteservice.request;

import com.eren.emlakcepteservice.entity.enums.RealtyKind;
import com.eren.emlakcepteservice.entity.enums.RealtyType;

public class RealtyRequest {

    private Integer no;
    private String title;
    private Integer userId;
    private String province;
    private String district;
    private RealtyKind kind;
    private RealtyType type;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public RealtyKind getKind() {
        return kind;
    }

    public void setKind(RealtyKind kind) {
        this.kind = kind;
    }

    public RealtyType getType() {
        return type;
    }

    public void setType(RealtyType type) {
        this.type = type;
    }
}
