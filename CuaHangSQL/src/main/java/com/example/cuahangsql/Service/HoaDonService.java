package com.example.cuahangsql.Service;

import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import java.util.List;


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
    public boolean checkMaHD(String maHD) {
        if (hoaDonRepository.findHoaDonByMaHD(maHD).isPresent()) {
            return false;
        }
        return true;
    }

}
