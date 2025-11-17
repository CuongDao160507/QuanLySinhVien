package com.example.quanlysinhvien.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lop_hoc")
public class LopHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_lop_hoc")
    private String tenLopHoc;

}
