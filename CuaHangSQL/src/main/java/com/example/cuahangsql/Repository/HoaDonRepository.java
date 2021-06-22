package com.example.cuahangsql.Repository;

import com.example.cuahangsql.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    @Override
    Optional<HoaDon> findById(String s);
}