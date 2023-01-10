package com.eren.emlakcepteservice.response;

import com.eren.emlakcepteservice.entity.enums.RealtyKind;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
import com.eren.emlakcepteservice.entity.enums.RealtyType;

import java.time.LocalDateTime;

public class RealtyResponse {

    private Integer id;
    private Integer no;
    private String title;
    private LocalDateTime createDate;
    private LocalDateTime publicationEnding;
    private UserResponse userResponse;
    private RealtyStatus status;
    private RealtyKind kind;
    private RealtyType type;
    private String province;
    private String district;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getPublicationEnding() {
        return publicationEnding;
    }

    public void setPublicationEnding(LocalDateTime publicationEnding) {
        this.publicationEnding = publicationEnding;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public RealtyStatus getStatus() {
        return status;
    }

    public void setStatus(RealtyStatus status) {
        this.status = status;
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
}
