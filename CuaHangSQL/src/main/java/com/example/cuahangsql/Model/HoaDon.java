package com.example.cuahangsql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "HoaDon")
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
    @Id
    @Column(name = "MaHD")
    private String maHD;
    @Column(name = "MaKH")
    private String maKH;
    @Column(name = "NgayLap")
    private String ngayLap;
    @Column(name = "TongTien")
    private int tongTien;

    public HoaDon(String maHD, String maKH, String ngayLap) {
        this.maHD = maHD;
        this.maKH = maKH;
        this.ngayLap = ngayLap;
        tongTien = 0;
    }
}
