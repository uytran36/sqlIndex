package com.example.cuahangsql.Controller;

import com.example.cuahangsql.Model.CtHoaDon;
import com.example.cuahangsql.Service.HoaDonService;
import com.example.cuahangsql.Service.CtHoaDonService;
import com.example.cuahangsql.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CtHoaDonController {
    @Autowired
    private CtHoaDonService CtHoaDonService;

    @Autowired
    private KhachHangService khachHangService;
    @RequestMapping(value = "/CTHD/{maHD}", method = RequestMethod.GET)
    public String CTHD(@PathVariable String maHD, Model model) {
        List<CtHoaDon> CTHD = CtHoaDonService.danhSachHoaDon(maHD);
        model.addAttribute("dsHDCT", CTHD);
        // Lấy record DB hiện lên HTML
        return "CTHD";
    }

    @GetMapping(value = "/DT")
    public String DT() {
        return "doanhThu";
    }
}
