package com.eren.emlakcepteservice.response;

import com.eren.emlakcepteservice.entity.enums.UserType;

public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private UserType type;
    private Integer usedPublicationRights;
    private Integer unusedPublicationRights;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Integer getUnusedPublicationRights() {
        return unusedPublicationRights;
    }

    public void setUnusedPublicationRights(Integer unusedPublicationRights) {
        this.unusedPublicationRights = unusedPublicationRights;
    }

    public Integer getUsedPublicationRights() {
        return usedPublicationRights;
    }

    public void setUsedPublicationRights(Integer usedPublicationRights) {
        this.usedPublicationRights = usedPublicationRights;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", usedPublicationRights=" + usedPublicationRights +
                ", unusedPublicationRights=" + unusedPublicationRights +
                '}';
    }
}
