package com.eren.emlakcepteservice.repository;

import com.eren.emlakcepteservice.entity.PublicationRight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<PublicationRight, Integer> {
}
