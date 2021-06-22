package com.example.cuahangsql.Repository;

import com.example.cuahangsql.Model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {
    Optional<KhachHang> findKhachHangByMaKH(String maKH);
}
