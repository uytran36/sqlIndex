package com.example.cuahangsql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping(value = "/add")
    private String themHoaDon() {
        return "add";
    }
}
