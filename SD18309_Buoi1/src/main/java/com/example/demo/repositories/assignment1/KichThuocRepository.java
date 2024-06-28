package com.example.demo.repositories.assignment1;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;

import java.util.ArrayList;
import java.util.List;

public class KichThuocRepository {
    private List<KichThuoc> ds;

    public KichThuocRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KichThuoc(1,"KT01","X",1));
        this.ds.add(new KichThuoc(2,"KT02","M",0));
        this.ds.add(new KichThuoc(3,"KT03","L",1));
        this.ds.add(new KichThuoc(4,"KT03","XL",1));
    }

    public List<KichThuoc> findAll(){
        return this.ds;
    }

    public void create(KichThuoc kt){
        this.ds.add(kt);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public KichThuoc findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(KichThuoc kt){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == kt.getId()){
                this.ds.set(i, kt);
            }
        }
    }


    public List<KichThuoc> search(String search){
        List<KichThuoc> searchList = new ArrayList<>();
        String s = search.trim();
        if (s.equals("")){
            return this.ds;
        }
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getMa().contains(s)
                    || this.ds.get(i).getTen().contains(s)){
                searchList.add(this.ds.get(i));
            }
        }
        return searchList;
    }
}
