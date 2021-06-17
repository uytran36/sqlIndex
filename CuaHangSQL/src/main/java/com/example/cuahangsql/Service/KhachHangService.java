package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.KhachHang;
import com.example.cuahangsql.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    public void luuKhachHang(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }
}
