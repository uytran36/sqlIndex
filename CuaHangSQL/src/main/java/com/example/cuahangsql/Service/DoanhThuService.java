package com.example.cuahangsql.Service;


import com.example.cuahangsql.Model.DoanhThuModel;
import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Model.SubDoanhThu;
import com.example.cuahangsql.Model.Tong;
import com.example.cuahangsql.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class DoanhThuService {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> danhSachMaSP(int thang, int nam) {
        String query = "SELECT distinct CT_HoaDon.MaSP \n" +
                "FROM CT_HoaDon\n" +
                "INNER JOIN HoaDon\n" +
                "ON HoaDon.MaHD = CT_HoaDon.MaHD and MONTH(NgayLap) = " + thang + " and YEAR(NgayLap) = " + nam + " ";
        return jdbcTemplate.queryForList(query, String.class);
        //return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(String.class));
    }

    public String getTenSP(String maSP) {
        String query = "select distinct SanPham.TenSP \n" +
                "from SanPham \n" +
                "inner join CT_HoaDon \n" +
                "on CT_HoaDon.MaSP = '"+ maSP +"' \n" +
                "and CT_HoaDon.MaSP = SanPham.MaSP";
        return jdbcTemplate.queryForObject(query, String.class);
    }
    public SubDoanhThu doanhThuSanPham(String maSP, int thang, int nam) {
        String query = "select SUM(CT_HoaDon.SoLuong) AS SoLuong, SUM(HoaDon.TongTien) AS TongTien\n" +
                "from HoaDon, CT_HoaDon, SanPham \n" +
                "where MONTH(NgayLap) = "+ thang +" \n" +
                "and YEAR(NgayLap) = " + nam + " \n" +
                "and HoaDon.MaHD = CT_HoaDon.MaHD \n" +
                "and CT_HoaDon.MaSP = '"+ maSP + "' \n" +
                "and CT_HoaDon.MaSP = SanPham.MaSP";
       // return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(DoanhThuModel.class));
        //return jdbcTemplate.query(query,(rs, rowNum) -> new DoanhThuModel(rs.getInt("SoLuong"),rs.getInt("TongTien")));
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new SubDoanhThu(rs.getInt("SoLuong"), rs.getInt("TongTien")));
    }

    public Tong tongDoanhThu(int thang, int nam) {
        String query = "select SUM(CAST(CT_HoaDon.SoLuong AS BIGINT)) AS SoLuong, SUM(CAST(HoaDon.TongTien AS BIGINT)) AS TongTien \n" +
                "from HoaDon, CT_HoaDon, SanPham \n" +
                "where MONTH(NgayLap) = " + thang + " \n" +
                "and YEAR(NgayLap) = " + nam + " \n" +
                "and HoaDon.MaHD = CT_HoaDon.MaHD \n" +
                "and CT_HoaDon.MaSP = SanPham.MaSP \n";
        return jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Tong(rs.getLong("SoLuong"), rs.getLong("TongTien")));
    }

}



