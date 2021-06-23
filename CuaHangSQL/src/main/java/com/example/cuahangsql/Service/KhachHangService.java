package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Model.KhachHang;
import com.example.cuahangsql.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void luuKhachHang(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }
    public boolean checkMaKH(String maKH) {
        String check = "SELECT MaKH FROM KHACHHANG";
        List<String> list = jdbcTemplate.queryForList(check, String.class);;
        for (String s : list) {
            if (s.equals(maKH)) {
                return true;
            }
        }
        return false;
    }
}
