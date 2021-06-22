package com.example.cuahangsql.Controller;
import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Model.KhachHang;
import com.example.cuahangsql.Service.HoaDonService;
import com.example.cuahangsql.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @GetMapping(value = "/index")
    public String homepage(Model model) {
//        model.addAttribute("dsHD", hoaDonService.danhSachHoaDon());
        return "index";
    }
    @GetMapping(value = "/add")
    public String maHoaDon(Model model) {
        model.addAttribute("maHD", hoaDonService.MahoaDonMoi());
        return "add";
    }
    @PostMapping(value = "/add")
    public String addHoaDon(HoaDon hoaDon)  {
        hoaDonService.luuHD(hoaDon);
        return "index";
    }
}
