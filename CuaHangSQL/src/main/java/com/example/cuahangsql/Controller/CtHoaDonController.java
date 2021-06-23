package com.example.cuahangsql.Controller;

import com.example.cuahangsql.Model.CtHoaDon;
import com.example.cuahangsql.Service.HoaDonService;
import com.example.cuahangsql.Service.CtHoaDonService;
import com.example.cuahangsql.Service.KhachHangService;
import com.example.cuahangsql.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Controller
public class CtHoaDonController {
    @Autowired
    private CtHoaDonService ctHoaDonService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private HoaDonService hoaDonService;
    @Autowired
    private KhachHangService khachHangService;
    @RequestMapping(value = "/CTHD/{maHD}", method = RequestMethod.GET)
    public String CTHD(@PathVariable String maHD, Model model) {
        List<CtHoaDon> CTHD = ctHoaDonService.danhSachHoaDon(maHD);
        model.addAttribute("dsHDCT", CTHD);
        // Lấy record DB hiện lên HTML
        return "CTHD";
    }

    @GetMapping(value = "/DT")
    public String DT() {
        return "doanhThu";
    }

    @GetMapping(value = "/addcthd")
    public String cthd(Model model) {
        model.addAttribute("maHD", ctHoaDonService.MahoaDon());
        return "addct";
    }

    @PostMapping(value = "/addcthd")
    public String addcthd(CtHoaDon ctHoaDon, RedirectAttributes ra) {
        if (!sanPhamService.checkSP(ctHoaDon.getMaSP())) {
            ra.addFlashAttribute("message", "Không tồn tại mã sản phẩm");
            return "redirect:/addcthd";
        }
        else if (ctHoaDon.getSoLuong() <= 0) {
            ra.addFlashAttribute("message", "Số lượng không hợp lệ");
            return "redirect:/addcthd";
        }
        else if (ctHoaDon.getGiaBan() <= 0 || ctHoaDon.getGiaGiam() < 0) {
            ra.addFlashAttribute("message", "Giá tiền không hợp lệ");
            return "redirect:/addcthd";
        }
        else if (ctHoaDon.getThanhTien() < 0) {
            ra.addFlashAttribute("message", "Thành tiền không hợp lệ");
        }
        ra.addFlashAttribute("message", "Thêm chi tiết thành công");
        ctHoaDonService.saveCtHD(ctHoaDon);
        String updateQuery = "UPDATE HoaDon SET TongTien = 0 WHERE MaHD = '" + ctHoaDon.getMaHD() + "'";
        jdbcTemplate.execute(updateQuery);
        return "redirect:/addcthd";

    }
}
