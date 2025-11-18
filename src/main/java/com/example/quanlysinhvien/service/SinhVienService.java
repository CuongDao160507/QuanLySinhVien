package com.example.quanlysinhvien.service;

import com.example.quanlysinhvien.entity.SinhVien;
import com.example.quanlysinhvien.repository.LopHocRepository;
import com.example.quanlysinhvien.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SinhVienService {
    @Autowired
    LopHocRepository lopHocRepository;

    @Autowired
    SinhVienRepository sinhVienRepository;

    public List<SinhVien> findAllSinhVien() {
        return sinhVienRepository.findAll();
    }
}
