package com.example.demo.repositories.assignment2;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichThuocRepository
        extends JpaRepository<KichThuoc, Integer> {
    public List<KichThuoc> findByTenLike(String keyword);
    public Page<KichThuoc> findByMaLikeOrTenLike(String keyword, String key, Pageable pageRequest);
}
