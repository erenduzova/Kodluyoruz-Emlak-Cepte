package com.eren.emlakcepteservice.converter;

import com.eren.emlakcepteservice.entity.PublicationRight;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.request.PublicationRightRequest;
import com.eren.emlakcepteservice.response.PublicationRightResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicationRightConverter {

    public PublicationRightResponse convert(PublicationRight publicationRight) {
        PublicationRightResponse response = new PublicationRightResponse();
        response.setId(publicationRight.getId());
        response.setDays(publicationRight.getDays());
        response.setUsed(publicationRight.isUsed());
        return response;
    }

    public PublicationRight convert(PublicationRightRequest publicationRightRequest, User user){
        PublicationRight publicationRight = new PublicationRight();
        publicationRight.setDays(publicationRightRequest.getDays()); // 30 days sent
        publicationRight.setUsed(false);
        publicationRight.setUser(user);
        return publicationRight;
    }



    public List<PublicationRightResponse> convert(List<PublicationRight> publicationRightList) {
        return publicationRightList.stream().map(this::convert).toList();
    }
}
