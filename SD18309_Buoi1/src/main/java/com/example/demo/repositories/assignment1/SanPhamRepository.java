package com.example.demo.repositories.assignment1;

import com.example.demo.entities.SanPham;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SanPhamRepository {
    private List<SanPham> ds;

    public SanPhamRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new SanPham(1,"SP01","Ao Phong",1));
        this.ds.add(new SanPham(2,"SP02","Ao So Mi",0));
        this.ds.add(new SanPham(3,"SP03","Vest",1));
        this.ds.add(new SanPham(4,"SP03","Ao Ni",1));
    }

    public List<SanPham> findAll(){
        return this.ds;
    }


    public List<SanPham> search(String search){
        List<SanPham> searchList = new ArrayList<>();
        String s = search.trim();
        if (s.equals("")){
            return this.ds;
        }
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getMa()
                    .contains(s)
                    || this.ds.get(i).getTen().contains(s)){
                searchList.add(this.ds.get(i));
            }
        }
        return searchList;
    }

    public void create(SanPham sp){
        this.ds.add(sp);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public SanPham findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(SanPham newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }


}
