package com.example.cuahangsql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping(name = "/add")
    private String themHoaDon() {
        return "add";
    }
}
