package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.io.*;
import org.jsoup.nodes.Document;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;
    
    public void luuHD(HoaDon hoaDon){
        hoaDonRepository.save(hoaDon);
    }
    public String MahoaDonMoi() {
        List<HoaDon> list = hoaDonRepository.findAll();
        StringBuilder s = new StringBuilder(list.get(list.size() - 1).getMaHD());
        String temp = s.substring(2);
        int result = Integer.parseInt(temp);
        result++;
        return Integer.toString(result);
    }

    private HoaDon layHoaDon() throws IOException {
        Document document = Jsoup.parse(new File("templates/add.html"), "utf-8");
        Element hd = document.getElementById("maHD");
        String maHD = hd.toString();
        hd = document.getElementById("tongTien");
        int tongTien = Integer.parseInt(hd.toString());
        hd = document.getElementById("ngayLap");
        String ngayLap = hd.toString();
        hd =  document.getElementById("maKH");
        String maKH = hd.toString();
        return new HoaDon("maHD", "maKH", "ngayLap", tongTien);

    }

}
