package com.eren.emlakcepteservice.repository;

import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealtyRepository extends JpaRepository<Realty, Integer> {

    List<Realty> findAllByUser(User user);
    List<Realty> findAllByStatus(RealtyStatus status);

    @Query("SELECT r FROM Realty r WHERE r.status = ?1 and r.user = ?2")
    List<Realty> findRealtyByStatusAndUser(RealtyStatus status, User user);
}
