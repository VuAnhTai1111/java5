package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="SanPhamChiTiet")
public class Spct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull
//    @DecimalMin("1")
    @Column(name = "IdSanPham")
    private Integer spId;

    @NotNull
//    @DecimalMin("1")
    @Column(name = "IdMauSac")
    private Integer mauSac;

    @NotNull
//    @DecimalMin("1")
    @Column(name = "IdKichThuoc")
    private Integer kichThuoc;

    @NotNull
//    @DecimalMin("1")
    @Column(name = "MaSPCT")
    private String ma;

    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;

    @NotNull
    @Column(name = "DonGia")
    private double donGia;

    @Column(name = "TrangThai")
    private int trangThai;
}
