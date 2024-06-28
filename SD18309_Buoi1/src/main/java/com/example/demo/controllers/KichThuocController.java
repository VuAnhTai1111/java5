package com.example.demo.controllers;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.repositories.assignment2.KichThuocRepository;
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
@RequestMapping("kich-thuoc")
public class KichThuocController {
    @Autowired
    private KichThuocRepository ktRepo;

    @RequestMapping("create")
    public String create(){
        return "kich_thuoc/create";
    }

    @PostMapping("store")
    public String store(
            Model model, @Valid KichThuoc sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "kich_thuoc/create";
        }else {
            this.ktRepo.save(sp);
            return "redirect:/kich-thuoc/index";
        }
    }

    @GetMapping("index")
    public String index(Model model,
                        @RequestParam(name = "page",defaultValue = "0") int pageNo,
                        @RequestParam(name = "limit",defaultValue = "10") int pageSize,
                        @RequestParam(name = "keyword",defaultValue = "") String keyword
    ){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        String keywordd = "%" + keyword + "%";
        Page<KichThuoc> ds = this.ktRepo.findByMaLikeOrTenLike(keywordd, keywordd, pageable);
//        List<KichThuoc> ds = this.ktRepo.findAll();
//        PageRequest p = PageRequest.of(pageNo,pageSize);
//        Page<KichThuoc> ds = this.spRepo.findAll(p);
//        keyword = "%" + keyword + "%";
//        List<KichThuoc> ds = this.ktRepo.findByTenLike(keyword);
        model.addAttribute("data", ds);
        model.addAttribute("keyword",keyword);
        return "kich_thuoc/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.ktRepo.deleteById(id);
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        KichThuoc kt = this.ktRepo.findById(id).get();
        model.addAttribute("data",kt);
        return "kich_thuoc/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid KichThuoc sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "kich_thuoc/edit";
        }else {
            this.ktRepo.save(sp);
            return "redirect:/kich-thuoc/index";
        }
    }

//    @GetMapping("search")
//    public String search(
//            @RequestParam("search") String s, Model model
//    ){
//        System.out.println(s);
//        List<KichThuoc> ds = this.ktRepo.search(s);
//        model.addAttribute("dataKT",ds);
//        return "kich_thuoc/index";
//    }
}
