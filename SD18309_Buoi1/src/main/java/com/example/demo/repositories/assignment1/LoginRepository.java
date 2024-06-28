package com.example.demo.repositories.assignment1;

import com.example.demo.entities.NhanVien;

import java.util.List;

public class LoginRepository {
    NhanVienRepository nvRepo = new NhanVienRepository();

//    public int login(String tk, String mk){
//        List<NhanVien> ds = nvRepo.findAll();
//        for (int i = 0; i < ds.size(); i++) {
//            if (ds.get(i).getTenDangNhap().equals(tk) && ds.get(i).getMatKhau().equals(mk)){
//                return ds.get(i).getRole();
//            }
//        }
//        return -1;
//    }
}
