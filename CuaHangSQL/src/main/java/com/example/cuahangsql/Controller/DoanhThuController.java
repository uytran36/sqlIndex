package com.example.cuahangsql.Controller;

import com.example.cuahangsql.Model.DoanhThuModel;
import com.example.cuahangsql.Model.SubDoanhThu;
import com.example.cuahangsql.Service.DoanhThuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoanhThuController {
    @Autowired
    private DoanhThuService doanhThuService;

    @GetMapping(value = "/doanhthu/{month}/{year}/{page}")
    public String doanhThu( @PathVariable("month") String month, @PathVariable("year") String year, @PathVariable("page") String page, Model model) {
        int monthInt = Integer.parseInt(month);
        int yearInt = Integer.parseInt(year);
        List<String> listMaDoanhThu = doanhThuService.danhSachMaSP(monthInt, yearInt);
        List<DoanhThuModel> listDoanhThu = new ArrayList<>();
//
//        int start = (Integer.parseInt(page) - 1) * 15;
//        int end = Integer.parseInt(page) * 15 - 1;

        int start = (Integer.parseInt(page) - 1) * 2;
        int end = Integer.parseInt(page) * 2 - 1;

        for(int i = start; i < end; i++) {
            if(i == listMaDoanhThu.size() - 1) {
                break;
            }

            String tenSP = doanhThuService.getTenSP(listMaDoanhThu.get(i));
            SubDoanhThu subDoanhThu = doanhThuService.doanhThuSanPham(listMaDoanhThu.get(i), monthInt, yearInt);
            DoanhThuModel doanhThu = new DoanhThuModel(tenSP, subDoanhThu.soLuong, subDoanhThu.tongTien);
            listDoanhThu.add(doanhThu);
        }

        model.addAttribute("temp", listDoanhThu);
        model.addAttribute("tong", doanhThuService.tongDoanhThu(monthInt, yearInt));
        return "doanhThu";
    }
}
