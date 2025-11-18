package com.example.quanlysinhvien.controller;

import com.example.quanlysinhvien.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;

    @GetMapping("/display")
    public String display(Model model) {
        model.addAttribute("listSV", sinhVienService.findAllSinhVien());
        return "sinhVien/display";
    }
}
