package com.example.cuahangsql.Controller;
import com.example.cuahangsql.Model.DoanhThuModel;
import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Model.KhachHang;
import com.example.cuahangsql.Model.SubDoanhThu;
import com.example.cuahangsql.Service.HoaDonService;
import com.example.cuahangsql.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;


@Controller
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @GetMapping(value = "/DSHD/{page}")
    public String listHD(Model model, @PathVariable("page") String page) {
        List<String> listMaHD = hoaDonService.danhSachMaHoaDon();
        List<HoaDon> listHD = new ArrayList<>();

        int start = (Integer.parseInt(page) - 1) * 15;
        int end = Integer.parseInt(page) * 15;

        for(int i = start; i < end; i++) {
            List<HoaDon> hoaDon = new ArrayList<>();
            hoaDon = hoaDonService.danhSachHoaDon(listMaHD.get(i));
            listHD.add(hoaDon.get(0));

            if(i == listMaHD.size() - 1) {
                break;
            }
        }

        model.addAttribute("dsHD", listHD);
        return "DSHD";
    }
//    @GetMapping(value = "/add")
//    public String maHoaDon(Model model) {
//        model.addAttribute("maHD", hoaDonService.MahoaDonMoi());
//        return "add";
//    }
    @PostMapping(value = "/add")
    public String addHoaDon(HoaDon hoaDon)  {
        hoaDonService.luuHD(hoaDon);
        return "index";
    }
}
