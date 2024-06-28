package com.example.demo.controllers;

import com.example.demo.entities.NhanVien;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.assignment2.NhanVienRepository;
import com.example.demo.repositories.assignment1.SanPhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienConTroller {
    @Autowired
    private NhanVienRepository nvRepo;

    @RequestMapping("create")
    public String create(){
        return "nhan_vien/create";
    }

    @PostMapping("store")
    public String store(
            Model model, @Valid NhanVien nv, BindingResult validateResult
    ){
        if (validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",nv);
            return "nhan_vien/create";
        }else {
            this.nvRepo.save(nv);
            return "redirect:/nhan-vien/index";
        }
    }

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int pageNo,
                        @RequestParam(name = "limit",defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword){
        model.addAttribute("keyword",keyword);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        String keywordd = "%" + keyword + "%";
        Page<NhanVien> ds = this.nvRepo.findByMaLikeOrTenLike(keywordd, keywordd, pageable);
//        List<NhanVien> ds = this.nvRepo.findAll();
//        PageRequest p = PageRequest.of(pageNo,pageSize);
//        Page<NhanVien> ds = this.spRepo.findAll(p);
//        keyword = "%" + keyword + "%";
//        List<NhanVien> ds = this.nvRepo.findByTenLike(keyword);
        model.addAttribute("data", ds);
        return "nhan_vien/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.nvRepo.deleteById(id);
        return "redirect:/nhan-vien/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        NhanVien nv = this.nvRepo.findById(id).get();
        model.addAttribute("data",nv);
        return "nhan_vien/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid NhanVien sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "nhan_vien/edit";
        }else {
            this.nvRepo.save(sp);
            return "redirect:/nhan-vien/index";
        }
    }

//    @GetMapping("search")
//    public String search(
//            @RequestParam("search") String s, Model model
//    ){
//        System.out.println(s);
//        List<NhanVien> ds = this.nvRepo.search(s);
//        model.addAttribute("data",ds);
//        return "nhan_vien/index";
//    }

//    @GetMapping("searchRole")
//    public String search(
//            @RequestParam("role") int role, Model model
//    ){
//        List<NhanVien> ds = this.nvRepo.Role(role);
//        model.addAttribute("data",ds);
//        return "nhan_vien/index";
//    }
}
