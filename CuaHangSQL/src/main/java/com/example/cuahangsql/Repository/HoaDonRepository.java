package com.example.cuahangsql.Repository;

import com.example.cuahangsql.Model.CtHoaDon;
import com.example.cuahangsql.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    @Override
    Optional<CtHoaDon> findById(String s);

}