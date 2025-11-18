package com.example.quanlysinhvien.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "sinh_vien")
public class SinhVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "| Ma sinh vien khong duoc de trong!")
    @Column(name = "ma_sinh_vien")
    private String maSinhVien;

    @NotBlank(message = "| Ho ten khong duoc de trong!")
    @Column(name = "ho_ten")
    private String hoTen;

    @NotNull(message = "| Gioi tinh khong duoc de trong!")
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @NotNull(message = "| GPA khong duoc de trong!")
    @Column(name = "gpa")
    private Float gpa;

    @NotNull(message = "| Trang thai khong duoc de trong!")
    @Column(name = "trang_thai")
    private Boolean trangThai;

    @ManyToOne
    @JoinColumn(name = "lop_hoc_id", referencedColumnName = "id")
    private LopHoc lopHoc;
}
