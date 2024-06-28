package com.example.demo.repositories.assignment1;

import com.example.demo.entities.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {
    private List<NhanVien> ds;

//    public NhanVienRepository(){
//        this.ds = new ArrayList<>();
//        this.ds.add(new NhanVien(1,"Phạm Trường An","NV01","NV001","pass01",1,1));
//        this.ds.add(new NhanVien(2,"Trần Tuấn","NV02","NV002","pass02",0,0));
//        this.ds.add(new NhanVien(3,"Nguyễn Cường","NV03","NV003","pass03",0,1));
//    }

    public List<NhanVien> findAll(){
        return this.ds;
    }

    public void create(NhanVien nv){
        this.ds.add(nv);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                this.ds.remove(i);
            }
        }
    }

    public NhanVien findById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == id){
                return this.ds.get(i);
            }
        }
        return null;
    }

    public void update(NhanVien newValue){
        for (int i = 0; i < this.ds.size(); i++) {
            if (ds.get(i).getId() == newValue.getId()){
                this.ds.set(i, newValue);
            }
        }
    }


//    public List<NhanVien> search(String search){
//        List<NhanVien> searchList = new ArrayList<>();
//        String s = search.trim();
//        if (s.equals("")){
//            return this.ds;
//        }
//        for (int i = 0; i < ds.size(); i++) {
//            if (this.ds.get(i).getMaNV().contains(s)
//                    || this.ds.get(i).getTen().contains(s)){
//                searchList.add(this.ds.get(i));
//            }
//        }
//        return searchList;
//    }


//    public List<NhanVien> Role(int role){
//        List<NhanVien> nhanViensRole = new ArrayList<>();
//        for (int i = 0; i < ds.size(); i++) {
//            if (this.ds.get(i).getRole() == role){
//                nhanViensRole.add(this.ds.get(i));
//            }
//        }
//        return nhanViensRole;
//    }
}
