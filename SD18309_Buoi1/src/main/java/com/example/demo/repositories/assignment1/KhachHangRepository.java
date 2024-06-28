package com.example.demo.repositories.assignment1;

import com.example.demo.entities.KhachHang;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    private List<KhachHang> ds;

//    public KhachHangRepository(){
//        this.ds = new ArrayList<>();
//        ds.add(new KhachHang(1,"KH01","Nguyen Hai Dang","0987654321","Ha Noi",1));
//        ds.add(new KhachHang(2,"KH02","Pham Kim Lien","0987654322","Hue",0));
//        ds.add(new KhachHang(3,"KH03","Tran Tuan","0987654323","Da Nang",1));
//    }

    public List<KhachHang> findAll(){
        return this.ds;
    }

    public void create(KhachHang kh){
        this.ds.add(kh);
    }

    public void deleteById(int id){
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public KhachHang findById(int id){
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(KhachHang kh){
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getId() == kh.getId()){
                this.ds.set(i,kh);
            }
        }
    }


//    public List<KhachHang> search(String search){
//        List<KhachHang> searchList = new ArrayList<>();
//        String s = search.trim();
//        if (s.equals("")){
//            return this.ds;
//        }
//        for (int i = 0; i < ds.size(); i++) {
//            if (this.ds.get(i).getMa().contains(s)
//                    || this.ds.get(i).getTen().contains(s)
//                    || this.ds.get(i).getSdt().equals(s)
//                    || this.ds.get(i).getDiaChi().contains(s)
//            ){
//                searchList.add(this.ds.get(i));
//            }
//        }
//        return searchList;
//    }
}
