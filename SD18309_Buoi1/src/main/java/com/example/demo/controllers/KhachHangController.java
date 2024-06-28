package com.example.demo.controllers;

import com.example.demo.entities.KhachHang;
import com.example.demo.repositories.assignment2.KhachHangRepository;
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
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangRepository khRepo;

    @RequestMapping("create")
    public String create(){
        return "khach_hang/create";
    }

    @PostMapping("store")
    public String store(
            Model model, @Valid KhachHang sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "khach_hang/create";
        }else {
            this.khRepo.save(sp);
            return "redirect:/khach-hang/index";
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
        Page<KhachHang> ds = this.khRepo.findByMaLikeOrTenLike(keywordd, keywordd, pageable);
//        List<KhachHang> ds = this.khRepo.findAll();
//        PageRequest p = PageRequest.of(pageNo,pageSize);
//        Page<KhachHang> ds = this.khRepo.findAll(p);
//        keyword = "%" + keyword + "%";
//        List<KhachHang> ds = this.khRepo.findByTenLike(keyword);
        model.addAttribute("data", ds);
        return "khach_hang/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.khRepo.deleteById(id);
        return "redirect:/khach-hang/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        KhachHang kh = this.khRepo.findById(id).get();
        model.addAttribute("data",kh);
        return "khach_hang/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid KhachHang sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "khach_hang/edit";
        }else {
            this.khRepo.save(sp);
            return "redirect:/khach-hang/index";
        }
    }

//    @GetMapping("search")
//    public String search(
//            @RequestParam("search") String s, Model model
//    ){
//        System.out.println(s);
//        List<KhachHang> ds = this.khRepo.search(s);
//        model.addAttribute("dataKH",ds);
//        return "khach_hang/index";
//    }
}
