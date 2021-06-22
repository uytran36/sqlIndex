package com.example.cuahangsql.Controller;
import com.example.cuahangsql.Model.HoaDon;
import com.example.cuahangsql.Service.HoaDonService;
import com.example.cuahangsql.Service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @GetMapping(value = "/DSHD/{page}")
    public String listHD(Model model, @PathVariable("page") String page) {
        List<HoaDon> listAllHD = hoaDonService.danhSachHoaDon();
        List<HoaDon> listHD = new ArrayList<>();

        int start = (Integer.parseInt(page) - 1) * 15;
        int end = Integer.parseInt(page) * 15 - 1;

        for(int i = start; i < end; i++) {
            HoaDon HoaDon = new HoaDon();
            HoaDon = listAllHD.get(i);
            listHD.add(HoaDon);

            if(i == listAllHD.size() - 1) {
                break;
            }
        }

        model.addAttribute("dsHD", listHD);
        return "DSHD";
    }
   @GetMapping(value = "/add")
   public String maHoaDon(Model model) {
       model.addAttribute("maHD", hoaDonService.MahoaDonMoi());
       return "add";
   }
    @PostMapping(value = "/add")
    public String addHoaDon(HoaDon hoaDon, RedirectAttributes ra) {
        if (!khachHangService.checkMaKH(hoaDon.getMaKH())) {
            ra.addFlashAttribute("message", "Mã khách hàng không tồn tại");
            return "redirect:/add";
        }
        else if (hoaDon.getNgayLap().equals("")) {
            ra.addFlashAttribute("message", "Vui lòng nhập ngày tháng");
            return "redirect:/add";
        }
        hoaDonService.luuHD(hoaDon);
        return "redirect:/addcthd";
    }
}
