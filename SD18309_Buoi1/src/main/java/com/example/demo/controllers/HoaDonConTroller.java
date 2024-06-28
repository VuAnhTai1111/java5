package com.example.demo.controllers;

import com.example.demo.entities.HoaDon;
import com.example.demo.entities.KhachHang;
import com.example.demo.entities.NhanVien;
import com.example.demo.repositories.assignment2.HoaDonRepository;
import com.example.demo.repositories.assignment2.KhachHangRepository;
import com.example.demo.repositories.assignment2.NhanVienRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hoa-don")
public class HoaDonConTroller {
    @Autowired
    private HoaDonRepository hdRepo;
    @Autowired
    private NhanVienRepository nvRepo;
    @Autowired
    private KhachHangRepository khRepo;

    @RequestMapping("create")
    public String create(){
        return "hoa_don/create";
    }

    @PostMapping("store")
    public String store(
            Model model, @Valid HoaDon hd, BindingResult validateResult
    ){
        if (validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",hd);

            return "hoa_don/create";
        }else {
            this.hdRepo.save(hd);
            return "redirect:/hoa-don/index";
        }
    }

    @GetMapping("index")
    public String index(
            @RequestParam(name = "page",defaultValue = "0") int pageNo,
            @RequestParam(name = "limit",defaultValue = "10") int pageSize,
            @RequestParam(name = "keyword",defaultValue = "") String keyword,
            Model model){
//        List<HoaDon> ds = this.hdRepo.findAll();
        PageRequest p = PageRequest.of(pageNo,pageSize);
        Page<HoaDon> ds = this.hdRepo.findAll(p);
        model.addAttribute("data", ds);
        List<NhanVien> dsNV = this.nvRepo.findAll();
        model.addAttribute("dataNV", dsNV);
        List<KhachHang> dsKH = this.khRepo.findAll();
        model.addAttribute("dataKH", dsKH);
        return "hoa_don/index";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.hdRepo.deleteById(id);
        return "redirect:/hoa-don/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HoaDon hd = this.hdRepo.findById(id).get();
        model.addAttribute("data",hd);
        return "hoa_don/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid HoaDon hd, BindingResult validateResult
    ){
        if (validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",hd);

            return "hoa_don/edit";
        }else {
            this.hdRepo.save(hd);
            return "redirect:/hoa-don/index";
        }

    }

//    @GetMapping("searchIdNV")
//    public String searchIdNV(
//            @RequestParam("idNhanVien") int id, Model model
//    ){
//        List<HoaDon> ds = this.hdRepo.searchIdNV(id);
//        model.addAttribute("data",ds);
//        List<NhanVien> dsNV = this.nvRepo.findAll();
//        model.addAttribute("dataNV", dsNV);
//        List<KhachHang> dsKH = this.khRepo.findAll();
//        model.addAttribute("dataKH", dsKH);
//        return "hoa_don/index";
//    }

//    @GetMapping("searchIdKH")
//    public String searchIdKH(
//            @RequestParam("idKhachHang") int id, Model model
//    ){
//        List<HoaDon> ds = this.hdRepo.searchIdKH(id);
//        model.addAttribute("data",ds);
//        List<NhanVien> dsNV = this.nvRepo.findAll();
//        model.addAttribute("dataNV", dsNV);
//        List<KhachHang> dsKH = this.khRepo.findAll();
//        model.addAttribute("dataKH", dsKH);
//        return "hoa_don/index";
//    }

//    @GetMapping("searchNgay")
//    public String searchNgay(
//            @RequestParam("tu") LocalDate tu, @RequestParam("den") LocalDate den , Model model
//    ){
//        List<HoaDon> ds = this.hdRepo.searchByNgay(tu,den);
//        model.addAttribute("data",ds);
//        List<NhanVien> dsNV = this.nvRepo.findAll();
//        model.addAttribute("dataNV", dsNV);
//        List<KhachHang> dsKH = this.khRepo.findAll();
//        model.addAttribute("dataKH", dsKH);
//        return "hoa_don/index";
//    }

}
