package com.example.demo.repositories.assignment1;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.Spct;

import java.util.ArrayList;
import java.util.List;

public class SpctRepository {
    private List<Spct> ds;

    public SpctRepository(){
        this.ds = new ArrayList<>();
        ds.add(new Spct(1,1,1,1,"1",100,250000,1));
        ds.add(new Spct(2,2,2,2,"2",20,100000,0));
        ds.add(new Spct(3,2,3,3,"3",10,90000,1));
        ds.add(new Spct(4,1,4,3,"4",29,222000,1));
    }

    public List<Spct> findAll(){
        return this.ds;
    }


    public List<Spct> findBySpId(int spId){
        List<Spct> kq = new ArrayList<>();
        for (Spct ct: ds) {
            if (ct.getSpId() == spId){
                kq.add(ct);
            }
        }
        return kq;
    }

    public void create(Spct ct){ds.add(ct);}

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public void update(Spct newMS){
        for (int i = 0; i < this.ds.size(); i++) {
            if (this.ds.get(i).getId() == newMS.getId()){
                this.ds.set(i,newMS);
            }
        }
    }

    public Spct findById(int id){
        for (int i = 0; i < ds.size(); i++) {
            if (this.ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public List<Spct> searchMS(int idsp, int idms){
        List<Spct> searchList = new ArrayList<>();
        for (Spct ct: ds) {
            if (ct.getSpId()==idsp && ct.getMauSac()==idms){
                searchList.add(ct);
            }
        }
        return searchList;
    }

    public List<Spct> searchGia(int tu, int den){
        List<Spct> searchL = new ArrayList<>();
        for (int i =0; i<ds.size();i++) {
            if (this.ds.get(i).getDonGia() == tu || this.ds.get(i).getDonGia() > tu){
                if (this.ds.get(i).getDonGia() == den || this.ds.get(i).getDonGia() < den){
                    searchL.add(this.ds.get(i));
                }
            }
        }
        return searchL;
    }

    public List<Spct> searchDen(int den){
        List<Spct> searchL = new ArrayList<>();
        for (int i =0; i<ds.size();i++) {
                if (this.ds.get(i).getDonGia() == den || this.ds.get(i).getDonGia() < den){
                    searchL.add(this.ds.get(i));
                }
        }
        return searchL;
    }

    public List<Spct> searchTu(int tu){
        List<Spct> searchL = new ArrayList<>();
        for (int i =0; i<ds.size();i++) {
            if (this.ds.get(i).getDonGia() == tu || this.ds.get(i).getDonGia() > tu){
                    searchL.add(this.ds.get(i));
            }
        }
        return searchL;
    }
}
