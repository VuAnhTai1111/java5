package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "HoaDonChiTiet")
public class HDChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @Column(name = "IdHoaDon")
    private int idHoaDon;

    @NotNull
    @Column(name = "IdSPCT")
    private int idSPCT;

    @NotNull
    @Column(name = "SoLuong")
    private int soLuong;

    @NotNull
    @Column(name = "DonGia")
    private double donGia;


    @NotNull
    @Column(name = "TrangThai")
    private int trangThai;

}
