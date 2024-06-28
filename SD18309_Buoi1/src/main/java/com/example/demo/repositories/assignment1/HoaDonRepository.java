package com.example.demo.repositories.assignment1;

import com.example.demo.entities.HoaDon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDonRepository {
    private List<HoaDon> ds;

    public HoaDonRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new HoaDon(1,1,2, LocalDate.of(2023,01,01),1));
        this.ds.add(new HoaDon(2,2,1, LocalDate.of(2024,05,24),0));
    }

    public List<HoaDon> findAll(){
        return this.ds;
    }

    public void create(HoaDon hd){
        this.ds.add(hd);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public HoaDon findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(HoaDon newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }

//    public List<HoaDon> searchIdNV(int id){
//        List<HoaDon> nhanViensRole = new ArrayList<>();
//        for (int i = 0; i < ds.size(); i++) {
//            if (this.ds.get(i).getIdNhanVien() == id){
//                nhanViensRole.add(this.ds.get(i));
//            }
//        }
//        return nhanViensRole;
//    }
//
//    public List<HoaDon> searchIdKH(int id){
//        List<HoaDon> nhanViensRole = new ArrayList<>();
//        for (int i = 0; i < ds.size(); i++) {
//            if (this.ds.get(i).getIdKhachHang()== id){
//                nhanViensRole.add(this.ds.get(i));
//            }
//        }
//        return nhanViensRole;
//    }

    public List<HoaDon> searchByNgay(LocalDate bt, LocalDate kt){
//        String tu = bt.trim();
//        String den = kt.trim();
//        int ddtu = Integer.parseInt(tu.substring(0,1));
//        int ddden = Integer.parseInt(den.substring(0,1));
//        int mmtu = Integer.parseInt(tu.substring(3,4));
//        int mmden = Integer.parseInt(den.substring(3,4));
//        int yyyytu = Integer.parseInt(tu.substring(6));
//        int yyyyden = Integer.parseInt(den.substring(6));
        List<HoaDon> nhanViensRole = new ArrayList<>();
        for (int i = 0; i < ds.size(); i++) {
//            int ddindex = Integer.parseInt(this.ds.get(i).getNgayMuaHang().substring(0,1));
//            int mmindex = Integer.parseInt(this.ds.get(i).getNgayMuaHang().substring(3,4));
            if (this.ds.get(i).getNgayMuaHang().isEqual(bt) ||
                    this.ds.get(i).getNgayMuaHang().isAfter(bt)

            ){
                if (this.ds.get(i).getNgayMuaHang().equals(kt) ||
                        this.ds.get(i).getNgayMuaHang().isBefore(kt)){
                    nhanViensRole.add(this.ds.get(i));
                }

            }
        }
        return nhanViensRole;
    }


}
