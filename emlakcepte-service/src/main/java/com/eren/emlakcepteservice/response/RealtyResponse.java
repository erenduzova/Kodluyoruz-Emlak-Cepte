package com.eren.emlakcepteservice.response;

import com.eren.emlakcepteservice.entity.enums.RealtyStatus;

import java.time.LocalDateTime;

public class RealtyResponse {

    private Integer id;
    private Integer no;
    private String title;
    private LocalDateTime createDate;
    private UserResponse userResponse;
    private RealtyStatus status;
    private String province;

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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
