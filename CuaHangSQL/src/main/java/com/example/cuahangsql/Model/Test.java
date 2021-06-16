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
@Table(name = "testHD")
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @Column(name = "test_MaHD")
    private String MaHD;
    @Column(name = "test_MaKH")
    private String MaKH;
    @Column(name = "test_NgayLap")
    private String NgayLap;
    @Column(name = "test_TongTien")
    private int TongTien;
}
