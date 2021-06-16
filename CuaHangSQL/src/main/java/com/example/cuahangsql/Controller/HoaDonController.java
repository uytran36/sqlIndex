package com.example.cuahangsql.Controller;


import com.example.cuahangsql.Repository.TestRepo;
import com.example.cuahangsql.Service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HoaDonController {
    @Autowired
    private HoaDonService hoaDonService;

    @GetMapping(value = "/index")
    public String homepage(Model model) {
        model.addAttribute("dsHD", hoaDonService.danhSachHoaDon());
        return "index";
    }
    @Autowired
    private TestRepo testRepo;

    @GetMapping(value = "/index1")
    public String test(Model model) {
        model.addAttribute("test", testRepo.findAll());
        System.out.println(testRepo.findAll());
        return "index2";
    }
}
