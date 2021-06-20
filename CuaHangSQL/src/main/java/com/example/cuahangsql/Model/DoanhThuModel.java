package com.example.cuahangsql.Model;

public class DoanhThuModel {
    public String tenSP;
    public Integer soLuong;
    public Integer tongTien;

    public DoanhThuModel() {
        this.tenSP = "";
        this.soLuong = 0;
        this.tongTien = 0;
    }
    public DoanhThuModel(String tenSP, Integer soLuong, Integer tongTien) {
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }
}