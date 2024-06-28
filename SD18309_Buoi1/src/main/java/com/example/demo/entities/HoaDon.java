package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @NotNull(message = "Xin vui lòng nhập dữ liệu")
//    @Digits(integer = 1,fraction = 0)
//    @DecimalMin("1")
    @Column(name = "IdNV")
    private Integer idNV;

    @NotNull(message = "Xin vui lòng nhập dữ liệu")
//    @Digits(integer = 1,fraction = 0)
//    @DecimalMin("1")
    @Column(name = "IdKH")
    private Integer idKH;

//    @NotNull
//    @NotBlank
    @Column(name = "NgayMuaHang")
    private LocalDate ngayMuaHang;

    @Column(name = "TrangThai")
    private int trangThai;
}
