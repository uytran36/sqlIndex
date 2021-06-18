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
@Table(name = "SanPham")
@AllArgsConstructor
@NoArgsConstructor
public class SanPham {
    @Id
    @Column(name = "MaSP")
    private String maSP;
    @Column(name = "TenSP")
    private String tenSP;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "Mota")
    private String moTa;
    @Column(name = "Gia")
    private int gia;
}
