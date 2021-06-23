package com.example.cuahangsql.Service;

import com.example.cuahangsql.Controller.CtHoaDonController;
import com.example.cuahangsql.Model.CtHoaDon;
import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Repository.CtHoaDonRepository;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CtHoaDonService {
    @Autowired
    private CtHoaDonRepository ctHoaDonRepository;

    public void saveAllCtHD(List<CtHoaDon> ctHoaDonList) {
        ctHoaDonRepository.saveAll(ctHoaDonList);
    }
    private CtHoaDonRepository CtHoaDonRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<CtHoaDon> danhSachHoaDon(String maHD) {
        String listHdct = "SELECT * FROM CT_HoaDon WHERE MaHD= '"+ maHD+"' ";
        return jdbcTemplate.query(listHdct, BeanPropertyRowMapper.newInstance(CtHoaDon.class));
    }
}
