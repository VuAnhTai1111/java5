package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SPCTCustom {
    @Id
    private Integer id;

    private String MauSac;
    private String KichThuoc;
    private String tenSP;
    private String ma;
    private int soLuong;
    private double donGia;
    private int trangThai;
}
