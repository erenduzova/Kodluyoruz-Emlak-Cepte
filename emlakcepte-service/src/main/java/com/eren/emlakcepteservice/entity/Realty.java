package com.eren.emlakcepteservice.entity;

import com.eren.emlakcepteservice.entity.enums.RealtyKind;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
import com.eren.emlakcepteservice.entity.enums.RealtyType;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "realty")
public class Realty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "realty_no", nullable = false)
    private Integer no;
    @Column(name = "title", nullable = false, length = 200)
    private String title;
    @Column(name = "create_date")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createDate;
    @Column(name = "publication_ending")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime publicationEnding;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName="id")
    private User user;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private RealtyStatus status;
    @Column(name = "kind")
    @Enumerated(EnumType.STRING)
    private RealtyKind kind;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RealtyType type;
    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    public Realty() {

    }

    public Realty(Integer no, String title, User user, String province, String district) {
        this.no = no;
        this.title = title;
        this.user = user;
        this.province = province;
        this.district = district;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Realty{" +
                "id=" + id +
                ", no=" + no +
                ", title='" + title + '\'' +
                ", createDate=" + createDate +
                ", publicationEnding=" + publicationEnding +
                ", status=" + status +
                ", kind=" + kind +
                ", type=" + type +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
