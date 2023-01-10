package com.eren.emlakcepteservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "publication_rights")
public class PublicationRight {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName="id")
    private User user;
    @Column(name = "days")
    private Integer days;
    @Column(name = "is_used")
    private boolean isUsed;

    public PublicationRight() {
    }

    public PublicationRight(User user, Integer days) {
        this.user = user;
        this.days = days;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    @Override
    public String toString() {
        return "PublicationRight{" +
                "id=" + id +
                ", days=" + days +
                ", isUsed=" + isUsed +
                '}';
    }
}
