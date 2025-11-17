package com.example.quanlysinhvien.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_sinh_vien")
    private String maSinhVien;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "gpa")
    private Float gpa;

    @Column(name = "trang_thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id")
    private LopHoc lopHoc;
}
