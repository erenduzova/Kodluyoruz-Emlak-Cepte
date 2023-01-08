package com.eren.emlakcepteservice.response;

public class ProvinceResponse {

    private String province;
    private Integer realtyCount;
    private Integer saleRealtyCount;
    private Integer saleHouseCount;
    private Integer saleLandCount;
    private Integer rentRealtyCount;
    private Integer rentHouseCount;
    private Integer rentLandCount;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getRealtyCount() {
        return realtyCount;
    }

    public void setRealtyCount(Integer realtyCount) {
        this.realtyCount = realtyCount;
    }

    public Integer getSaleRealtyCount() {
        return saleRealtyCount;
    }

    public void setSaleRealtyCount(Integer saleRealtyCount) {
        this.saleRealtyCount = saleRealtyCount;
    }

    public Integer getSaleHouseCount() {
        return saleHouseCount;
    }

    public void setSaleHouseCount(Integer saleHouseCount) {
        this.saleHouseCount = saleHouseCount;
    }

    public Integer getSaleLandCount() {
        return saleLandCount;
    }

    public void setSaleLandCount(Integer saleLandCount) {
        this.saleLandCount = saleLandCount;
    }

    public Integer getRentRealtyCount() {
        return rentRealtyCount;
    }

    public void setRentRealtyCount(Integer rentRealtyCount) {
        this.rentRealtyCount = rentRealtyCount;
    }

    public Integer getRentHouseCount() {
        return rentHouseCount;
    }

    public void setRentHouseCount(Integer rentHouseCount) {
        this.rentHouseCount = rentHouseCount;
    }

    public Integer getRentLandCount() {
        return rentLandCount;
    }

    public void setRentLandCount(Integer rentLandCount) {
        this.rentLandCount = rentLandCount;
    }
}
