package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.*;
import org.jsoup.nodes.Document;
import java.util.List;
import java.util.Optional;

//import static com.example.cuahangsql.Repository.HoaDonRepository.firstPage;

@Service
public class HoaDonService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<HoaDon> danhSachHoaDon() {

        String listHd = "SELECT * FROM HoaDon";
        return jdbcTemplate.query(listHd, BeanPropertyRowMapper.newInstance(HoaDon.class));

    }
    
    public void luuHD(HoaDon hoaDon){
        hoaDonRepository.save(hoaDon);
    }
    public String MahoaDonMoi() {
        String query = "SELECT TOP 1 MaHD FROM HoaDon ORDER BY MaHD DESC";
        List<HoaDon> list = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(HoaDon.class));
        StringBuilder temp = new StringBuilder(list.get(0).getMaHD());
        String s = temp.substring(2);
        int result = Integer.parseInt(s);
        result++;
        String id = "HD";
        while ((id + result).length() < 10) {
            id += "0";
        }
        return (id + result);
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
