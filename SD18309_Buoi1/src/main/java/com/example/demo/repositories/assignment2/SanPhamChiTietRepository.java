package com.example.demo.repositories.assignment2;

import com.example.demo.entities.SPCTCustom;
import com.example.demo.entities.Spct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamChiTietRepository
        extends JpaRepository<Spct, Integer> {
    @Query(
            "SELECT new SPCTCustom (" +
                    " spct.id, ms.ten, kt.ten, sp.ten, spct.ma, " +
                    " spct.soLuong, spct.donGia, spct.trangThai)" +
                    " FROM Spct spct JOIN SanPham sp ON spct.spId = sp.id JOIN MauSac ms on  spct.mauSac = ms.id join KichThuoc kt on spct.kichThuoc = kt.id"
    )
    public List<SPCTCustom> findAllWithPropName();
    @Query(
            "SELECT new SPCTCustom (" +
                    " spct.id, ms.ten, kt.ten, sp.ten, spct.ma, " +
                    " spct.soLuong, spct.donGia, spct.trangThai)" +
                    " FROM Spct spct JOIN SanPham sp ON spct.spId = sp.id JOIN MauSac ms on  spct.mauSac = ms.id join KichThuoc kt on spct.kichThuoc = kt.id where spct.spId = :keyword "
    )
    public Page<SPCTCustom> findAllWithPropNameSanPham(@Param("keyword") int keyword, Pageable page);
    @Query(
            "SELECT new SPCTCustom (" +
                    " spct.id, ms.ten, kt.ten, sp.ten, spct.ma, " +
                    " spct.soLuong, spct.donGia, spct.trangThai)" +
                    " FROM Spct spct JOIN SanPham sp ON spct.spId = sp.id JOIN MauSac ms on  spct.mauSac = ms.id join KichThuoc kt on spct.kichThuoc = kt.id where spct.spId = -1 "
    )
    public Page<SPCTCustom> findAllWithPropNameFail( Pageable page);
}
