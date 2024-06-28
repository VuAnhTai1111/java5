package com.example.demo.repositories.assignment2;

import com.example.demo.entities.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository
        extends JpaRepository<SanPham, Integer> {
//    @Query("SELECT sp from SanPham sp where sp.ten like :keyword or sp.ma like :keyword")
//    public List<SanPham> findBy(@Param("keyword") String keyword);

    public List<SanPham> findByTenLike(String keyword);
    public Page<SanPham> findByMaLikeOrTenLike(String keyword, String key, Pageable pageRequest);
}
