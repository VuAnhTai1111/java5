package com.example.demo.repositories.assignment1;

import com.example.demo.entities.HDChiTiet;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.Spct;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietRepository {
    List<HDChiTiet> ds;

    public HoaDonChiTietRepository(){
        ds= new ArrayList<>();
        ds.add(new HDChiTiet(1,2,1,1,1000,1));
        ds.add(new HDChiTiet(2,1,2,45,87000,1));
        ds.add(new HDChiTiet(3,1,1,35,111000,1));
        ds.add(new HDChiTiet(4,2,2,15,22000,1));
    }

    public List<HDChiTiet> findAll(){
        return this.ds;
    }

    public void create(HDChiTiet ms){
        this.ds.add(ms);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public HDChiTiet findById(int id){
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(HDChiTiet newMS){
        for (int i = 0; i < this.ds.size(); i++) {
            if (this.ds.get(i).getId() == newMS.getId()){
                this.ds.set(i,newMS);
            }
        }
    }


    public List<HDChiTiet> findByIdHD(int spId){
        List<HDChiTiet> kq = new ArrayList<>();
        for (HDChiTiet ct: ds) {
            if (ct.getIdHoaDon() == spId){
                kq.add(ct);
            }
        }
        return kq;
    }
    public List<HDChiTiet> findByIdSPCT(int spId){
        List<HDChiTiet> kq = new ArrayList<>();
        for (HDChiTiet ct: ds) {
            if (ct.getIdSPCT() == spId){
                kq.add(ct);
            }
        }
        return kq;
    }
}
