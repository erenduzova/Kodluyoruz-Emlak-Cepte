package com.eren.emlakcepteservice.repository;

import com.eren.emlakcepteservice.entity.Realty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyRepository extends JpaRepository<Realty, Integer> {
}
