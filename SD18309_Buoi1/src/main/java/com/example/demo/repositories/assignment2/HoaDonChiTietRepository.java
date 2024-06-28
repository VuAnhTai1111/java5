package com.example.demo.repositories.assignment2;

import com.example.demo.entities.HDChiTiet;
import com.example.demo.entities.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository
        extends JpaRepository<HDChiTiet, Integer> {
}
