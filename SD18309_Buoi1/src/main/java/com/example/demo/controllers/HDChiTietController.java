package com.example.demo.controllers;

import com.example.demo.entities.HDChiTiet;
import com.example.demo.entities.HoaDon;
import com.example.demo.entities.KhachHang;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.NhanVien;
import com.example.demo.entities.Spct;
import com.example.demo.repositories.assignment2.HoaDonChiTietRepository;
import com.example.demo.repositories.assignment2.HoaDonRepository;
import com.example.demo.repositories.assignment2.SanPhamChiTietRepository;
import com.example.demo.repositories.assignment1.SpctRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("hd-ct")
public class HDChiTietController {
    @Autowired
    HoaDonChiTietRepository hoaDonCTRepo;
    @Autowired
    SanPhamChiTietRepository spctRepository ;
    @Autowired
    HoaDonRepository hdRepo;

    @RequestMapping("create")
    public String create(){
        return "hd_ct/create";
    }

    @PostMapping("store")
    public String store(
            Model model, @Valid HDChiTiet hd, BindingResult validateResult
    ){
        if (validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",hd);

            return "hd_ct/create";
        }else {
            this.hoaDonCTRepo.save(hd);
            return "redirect:/hd-ct/index";
        }
    }

    @GetMapping("index")
    public String index(Model model){
        List<HoaDon> ds = this.hdRepo.findAll();
        model.addAttribute("dataHD", ds);
        List<HDChiTiet> dsNV = this.hoaDonCTRepo.findAll();
        model.addAttribute("data", dsNV);
        List<Spct> dsKH = this.spctRepository.findAll();
        model.addAttribute("dataSPCT", dsKH);
        return "hd_ct/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        HDChiTiet ms = this.hoaDonCTRepo.findById(id).get();
        model.addAttribute("data",ms);
        return "hd_ct/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid HDChiTiet hd, BindingResult validateResult
    ){
        if (validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",hd);

            return "hd_ct/edit";
        }else {
            this.hoaDonCTRepo.save(hd);
            return "redirect:/hd_ct/index";
        }

    }

//    @GetMapping("searchIdHD")
//    public String searchIdHD(
//            @RequestParam("idHoaDon") int id, Model model
//    ){
//        List<HoaDon> ds = this.hdRepo.searchIdNV(id);
//        model.addAttribute("dataHD",ds);
//        List<HDChiTiet> dsNV = this.hoaDonCTRepo.findByIdHD(id);
//        model.addAttribute("data", dsNV);
//        List<Spct> dsKH = this.spctRepository.findAll();
//        model.addAttribute("dataSPCT", dsKH);
//        return "hd_ct/index";
//    }

//    @GetMapping("searchIdSPCT")
//    public String searchIdSPCT(
//            @RequestParam("idSPCT") int id, Model model
//    ){
//        List<HoaDon> ds = this.hdRepo.searchIdNV(id);
//        model.addAttribute("dataHD",ds);
//        List<HDChiTiet> dsNV = this.hoaDonCTRepo.findByIdSPCT(id);
//        model.addAttribute("data", dsNV);
//        List<Spct> dsKH = this.spctRepository.findAll();
//        model.addAttribute("dataSPCT", dsKH);
//        return "hd_ct/index";
//    }
}
