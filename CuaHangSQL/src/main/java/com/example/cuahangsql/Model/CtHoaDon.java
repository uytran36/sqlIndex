package com.example.cuahangsql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "CT_HoaDon")
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CtHoaDonId.class)
public class CtHoaDon {
    @Id
    @Column(name = "MaHD")
    private String maHD;
    @Id
    @Column(name = "MaSP")
    private String maSP;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "GiaBan")
    private int giaBan;
    @Column(name = "GiaGiam")
    private int giaGiam;
    @Column(name = "ThanhTien")
    private int thanhTien;
}
