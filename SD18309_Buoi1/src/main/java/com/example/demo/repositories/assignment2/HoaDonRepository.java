package com.example.demo.repositories.assignment2;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository
        extends JpaRepository<HoaDon, Integer> {
    public Page<HoaDon> findByIdNV(Integer keyword, Pageable pageRequest);
    public Page<HoaDon> findByIdKH(Integer keyword, Pageable pageRequest);
}
