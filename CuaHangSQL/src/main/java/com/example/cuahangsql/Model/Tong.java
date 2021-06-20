package com.example.cuahangsql.Model;

public class Tong {
    public Long soLuong;
    public Long tongTien;

    public Tong() {
        this.soLuong = 0L;
        this.tongTien = 0L;
    }
    public Tong(Long soLuong, Long tongTien) {

        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
}
