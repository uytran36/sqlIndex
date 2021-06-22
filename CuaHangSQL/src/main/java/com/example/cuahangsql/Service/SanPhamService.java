package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.SanPham;
import com.example.cuahangsql.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    public boolean checkSP(String maSP) {
        if (sanPhamRepository.findSanPhamByMaSP(maSP).isPresent()) {
            return true;
        }
        return false;
    }
}
