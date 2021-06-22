package com.example.cuahangsql.Service;

import com.example.cuahangsql.Controller.CtHoaDonController;
import com.example.cuahangsql.Model.CtHoaDon;
import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Repository.CtHoaDonRepository;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CtHoaDonService {
    @Autowired
    private CtHoaDonRepository ctHoaDonRepository;

    public void saveCtHD(CtHoaDon ctHoaDon) {
        ctHoaDonRepository.save(ctHoaDon);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CtHoaDon> danhSachHoaDon(String maHD) {
        String listHdct = "SELECT * FROM CT_HoaDon WHERE MaHD= '"+ maHD+"' ";
        return jdbcTemplate.query(listHdct, BeanPropertyRowMapper.newInstance(CtHoaDon.class));
    }

    public String MahoaDon() {
        String query = "SELECT TOP 1 MaHD FROM HoaDon ORDER BY MaHD DESC";
        List<HoaDon> list = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(HoaDon.class));
        return list.get(0).getMaHD();
    }
}
