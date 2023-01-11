package com.eren.emlakcepteservice.repository;

import com.eren.emlakcepteservice.entity.Realty;
import com.eren.emlakcepteservice.entity.User;
import com.eren.emlakcepteservice.entity.enums.RealtyKind;
import com.eren.emlakcepteservice.entity.enums.RealtyStatus;
import com.eren.emlakcepteservice.entity.enums.RealtyType;
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

    List<Realty> findAllByProvince(String searchedProvince);

    List<Realty> findAllByDistrict(String searchedDistrict);

    @Query("SELECT r FROM Realty r WHERE r.province = ?1 and r.type = ?2")
    List<Realty> findAllByProvinceAndRealtyType(String province, RealtyType type);

    @Query("SELECT r FROM Realty r WHERE r.province = ?1 and r.kind = ?2")
    List<Realty> findAllByProvinceAndRealtyKind(String province, RealtyKind kind);

    @Query("SELECT r FROM Realty r WHERE r.province = ?1 and r.kind = ?2 and r.type = ?3")
    List<Realty> findAllByProvinceAndRealtyKindAndType(String province, RealtyKind kind, RealtyType type);
}
