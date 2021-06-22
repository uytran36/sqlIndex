package com.example.cuahangsql.Controller;

import com.example.cuahangsql.Repository.SanPhamRepository;
import com.example.cuahangsql.Service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

}
