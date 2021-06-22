package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


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
    
    public void luuHD(HoaDon hoaDon) {
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

}
