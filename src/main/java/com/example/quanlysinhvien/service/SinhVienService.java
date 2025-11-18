package com.example.quanlysinhvien.service;

import com.example.quanlysinhvien.entity.SinhVien;
import com.example.quanlysinhvien.repository.LopHocRepository;
import com.example.quanlysinhvien.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {
    @Autowired
    LopHocRepository lopHocRepository;

    @Autowired
    SinhVienRepository sinhVienRepository;

    public List<SinhVien> findAllSinhVien() {
        return sinhVienRepository.findAll();
    }

    public void addSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    public List<SinhVien> findSinhVienById(Integer id) {
        return sinhVienRepository.findById(id).orElse(null);
    }

    public void updateSinhVien(SinhVien sinhVien) {
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien(Integer id) {
        sinhVienRepository.deleteById(id);
    }

}
