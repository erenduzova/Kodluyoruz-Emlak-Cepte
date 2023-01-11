package com.eren.emlakcepteservice.client.model;

import com.eren.emlakcepteservice.entity.enums.RealtyKind;
import com.eren.emlakcepteservice.entity.enums.RealtyType;

public class Banner {

    private int realtyNo;
    private int quantity;
    private String title;
    private String province;
    private String district;
    private String email;

    public Banner() {
    }

    public Banner(int realtyNo, int quantity, String title, RealtyKind kind, RealtyType type, String province, String district, String email) {
        this.realtyNo = realtyNo;
        this.quantity = quantity;
        this.title = title;
        this.province = province;
        this.district = district;
        this.email = email;
    }

    public int getRealtyNo() {
        return realtyNo;
    }

    public void setRealtyNo(int realtyNo) {
        this.realtyNo = realtyNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
