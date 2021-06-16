package com.example.cuahangsql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "KhachHang")
@NoArgsConstructor
@AllArgsConstructor
public class KhachHang {
    @Id
    @Column(name = "MaKH")
    private String maKH;
    @Column(name = "Ho")
    private String Ho;
    @Column(name = "Ten")
    private String Ten;
    @Column(name = "Ngsinh")
    private String ngSinh;
    @Column(name = "SoNha")
    private String soNha;
    @Column(name = "Duong")
    private String duong;
    @Column(name = "Phuong")
    private String phuong;
    @Column(name = "Quan")
    private String quan;
    @Column(name = "Tpho")
    private String thPho;
    @Column(name = "DienThoai")
    private String dienThoai;

}
