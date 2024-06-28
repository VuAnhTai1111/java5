package com.example.demo.controllers;

import com.example.demo.entities.MauSac;
import com.example.demo.entities.SanPham;
import com.example.demo.repositories.assignment2.MauSacRepository;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository msRepo;

    @RequestMapping("create")
    public String create(){
        return "mau_sac/create";
    }

    @PostMapping("store")
    public String store(
            Model model, @Valid MauSac sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "mau_sac/create";
        }else {
            this.msRepo.save(sp);
            return "redirect:/mau-sac/index";
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
        Page<MauSac> ds = this.msRepo.findByMaLikeOrTenLike(keywordd, keywordd, pageable);
//        PageRequest p = PageRequest.of(pageNo,pageSize);
//        Page<MauSac> ds = this.msRepo.findAll(p);
//        List<MauSac> ds = this.msRepo.findAll();
//        keyword = "%" + keyword + "%";
//        List<MauSac> ds = this.msRepo.findByTenLike(keyword);
        model.addAttribute("data", ds);
        model.addAttribute("keyword",keyword);
        return "mau_sac/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.msRepo.deleteById(id);
        return "redirect:/mau-sac/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        MauSac ms = this.msRepo.findById(id).get();
        model.addAttribute("data",ms);
        return "mau_sac/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid MauSac sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "mau_sac/edit";
        }else {
            this.msRepo.save(sp);
            return "redirect:/mau-sac/index";
        }
    }

//    @GetMapping("search")
//    public String search(
//            @RequestParam("search") String s, Model model
//    ){
//        System.out.println(s);
//        List<MauSac> ds = this.msRepo.search(s);
//        model.addAttribute("dataMS",ds);
//        return "mau_sac/index";
//    }
}
