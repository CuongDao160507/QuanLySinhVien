package com.example.quanlysinhvien.controller;

import com.example.quanlysinhvien.entity.LopHoc;
import com.example.quanlysinhvien.entity.SinhVien;
import com.example.quanlysinhvien.repository.LopHocRepository;
import com.example.quanlysinhvien.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {
    @Autowired
    SinhVienService sinhVienService;

    @Autowired
    LopHocRepository lopHocRepository;

    @ModelAttribute("listLH")
    public List<LopHoc> findAllLopHoc() {
        return lopHocRepository.findAll();
    }

    @GetMapping("/display")
    public String display(Model model) {
        model.addAttribute("listSV", sinhVienService.findAllSinhVien());
        model.addAttribute("sv", new SinhVien());
        return "sinhVien/display";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("sv") SinhVien sinhVien) {
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinh-vien/display";
    }
}
