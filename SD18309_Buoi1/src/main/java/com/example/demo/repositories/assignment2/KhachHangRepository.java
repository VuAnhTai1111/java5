package com.example.demo.repositories.assignment2;

import com.example.demo.entities.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository
        extends JpaRepository<KhachHang, Integer> {
    public List<KhachHang> findByTenLike(String keyword);
    public Page<KhachHang> findByMaLikeOrTenLike(String keyword, String key, Pageable pageRequest);
}
