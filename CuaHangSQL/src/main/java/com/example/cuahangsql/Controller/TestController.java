package com.example.cuahangsql.Controller;

import com.example.cuahangsql.Model.Test;
import com.example.cuahangsql.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping(value = "/index1")
    public String test(Model model) {
        model.addAttribute("t", testService.test());
        return "test";
    }
}
