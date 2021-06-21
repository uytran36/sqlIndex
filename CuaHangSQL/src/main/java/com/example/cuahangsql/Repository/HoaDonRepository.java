package com.example.cuahangsql.Repository;

import com.example.cuahangsql.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    @Override
    Optional<HoaDon> findById(String s);
}
