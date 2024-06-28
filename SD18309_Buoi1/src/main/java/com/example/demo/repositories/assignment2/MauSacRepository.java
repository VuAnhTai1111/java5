package com.example.demo.repositories.assignment2;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository
        extends JpaRepository<MauSac, Integer> {
    public List<MauSac> findByTenLike(String keyword);
    public Page<MauSac> findByMaLikeOrTenLike(String keyword, String key, Pageable pageRequest);
}
