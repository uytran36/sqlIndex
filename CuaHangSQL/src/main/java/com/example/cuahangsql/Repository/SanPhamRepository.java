package com.example.cuahangsql.Repository;

import com.example.cuahangsql.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SanPhamRepository extends JpaRepository<SanPham, String> {
    Optional<SanPham> findSanPhamByMaSP(String maSP);
}
