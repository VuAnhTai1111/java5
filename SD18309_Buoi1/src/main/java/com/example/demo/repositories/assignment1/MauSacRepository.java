package com.example.demo.repositories.assignment1;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private List<MauSac> ds;

    public MauSacRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new MauSac(1,"MS01","Vang",1));
        this.ds.add(new MauSac(2,"MS02","Do",0));
        this.ds.add(new MauSac(3,"MS03","Cam",0));
    }

    public List<MauSac> findAll(){
        return this.ds;
    }

    public void create(MauSac ms){
        this.ds.add(ms);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public MauSac findById(int id){
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(MauSac newMS){
        for (int i = 0; i < this.ds.size(); i++) {
            if (this.ds.get(i).getId() == newMS.getId()){
                this.ds.set(i,newMS);
            }
        }
    }


    public List<MauSac> search(String search){
        List<MauSac> searchList = new ArrayList<>();
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
