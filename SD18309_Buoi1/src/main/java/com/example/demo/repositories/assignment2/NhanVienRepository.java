package com.example.demo.repositories.assignment2;

import com.example.demo.entities.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository
        extends JpaRepository<NhanVien, Integer> {
    public List<NhanVien> findByTenLike(String keyword);
    public Page<NhanVien> findByMaLikeOrTenLike(String keyword, String key, Pageable pageRequest);
    public  NhanVien findByTenDangNhapEqualsAndMatKhauEquals(String tk, String mk);
}
