package com.eren.emlakceptebannerservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "banners")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private int realtyNo;
    private int quantity;
    private String title;
    private String province;
    private String district;
    private String email;

    public Banner() {
    }

    public Banner(Banner banner) {
        this.realtyNo = banner.realtyNo;
        this.quantity = banner.quantity;
        this.title = banner.title;
        this.province = banner.province;
        this.district = banner.district;
        this.email = banner.email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
