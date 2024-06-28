package com.example.demo.controllers;

import com.example.demo.entities.SanPham;
//import com.example.demo.repositories.assignment1.SanPhamRepository;
import com.example.demo.repositories.assignment2.SanPhamRepository;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("san-pham")
public class SanPhamConTroller {
//    private SanPhamRepository spRepo = new SanPhamRepository(); asm1
    @Autowired
    private SanPhamRepository spRepo;

    @RequestMapping("create")
//    @GetMapping("san-pham/create")

//    public String create(@ModelAttribute("data") SanPham sp){
//        return "san_pham/create";
//    }
    public String create(){
        return "san_pham/create";
    }

//    @RequestMapping(
//            value = "san-pham/store",
//            method = RequestMethod.POST
//    )
    @PostMapping("store")
    public String store(
//            @RequestParam("ma") String maSP,
//            @RequestParam("ten") String tenSP,
//            @RequestParam("trangThai") Integer trangThaiSP    //Làm chay
            Model model, @Valid SanPham sp, BindingResult validateResult
    ){
//        System.out.println("_?_?_?_?_?_?_?_");
//        System.out.println(maSP);
//        System.out.println(tenSP);
//        System.out.println(trangThaiSP);
//        System.out.println("_?_?_?_?_?_?_?_");

//        SanPham sp = new SanPham(null,maSP,tenSP,trangThaiSP); //Làm chay

        if (validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "san_pham/create";
        }else {
            this.spRepo.save(sp);
            return "redirect:/san-pham/index";
        }
    }

    @GetMapping("index")
    public String index(
            @RequestParam(name = "page",defaultValue = "0") int pageNo,
            @RequestParam(name = "limit",defaultValue = "10") int pageSize,
            @RequestParam(name = "keyword",defaultValue = "") String keyword,
            Model model){
        model.addAttribute("keyword",keyword);
        PageRequest p = PageRequest.of(pageNo,pageSize);
//        Page<SanPham> ds = this.spRepo.findAll(p);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
         String keywordd = "%" + keyword + "%";
        Page<SanPham> ds = this.spRepo.findByMaLikeOrTenLike(keywordd, keywordd, pageable);
//        List<SanPham> ds = this.spRepo.findByMaLikeOrTenLike(keyword,keyword,p);
//        List<SanPham> ds = this.spRepo.findAll();
        model.addAttribute("data", ds);
        return "san_pham/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.spRepo.deleteById(id);
        return "redirect:/san-pham/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        SanPham sp = this.spRepo.findById(id).get();
//        dùng JPA mới có .get()
        model.addAttribute("data",sp);
        return "san_pham/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid SanPham sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "san_pham/edit";
        }else {
            this.spRepo.save(sp);
            return "redirect:/san-pham/index";
        }
    }

//    @GetMapping("search")
//    public String search(
//            @RequestParam("search") String s, Model model
//    ){
//        System.out.println(s);
//        List<SanPham> ds = this.spRepo.search(s);
//        model.addAttribute("data",ds);
//       return "san_pham/index";
//    }

}
