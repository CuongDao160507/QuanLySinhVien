package com.example.quanlysinhvien.controller;

import com.example.quanlysinhvien.entity.LopHoc;
import com.example.quanlysinhvien.entity.SinhVien;
import com.example.quanlysinhvien.repository.LopHocRepository;
import com.example.quanlysinhvien.service.SinhVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String add(@Valid @ModelAttribute("sv") SinhVien sinhVien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listSV", sinhVienService.findAllSinhVien());
            return "sinhVien/display";
        }
        sinhVienService.addSinhVien(sinhVien);
        return "redirect:/sinh-vien/display";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("sv", sinhVienService.findSinhVienById(id));
        return "sinhVien/viewUpdate";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id,@ModelAttribute("sv") SinhVien sinhVien) {
        sinhVien.setId(id);
        sinhVienService.updateSinhVien(sinhVien);
        return "redirect:/sinh-vien/display";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        sinhVienService.deleteSinhVien(id);
        return "redirect:/sinh-vien/display";
    }
}
