package com.example.demo.controllers;

import com.example.demo.entities.KichThuoc;
import com.example.demo.entities.MauSac;
import com.example.demo.entities.SPCTCustom;
import com.example.demo.entities.SanPham;
import com.example.demo.entities.Spct;
import com.example.demo.repositories.assignment2.KichThuocRepository;
import com.example.demo.repositories.assignment2.MauSacRepository;
import com.example.demo.repositories.assignment2.SanPhamChiTietRepository;
import com.example.demo.repositories.assignment2.SanPhamRepository;
import com.example.demo.repositories.assignment1.SpctRepository;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("spct")
public class SpctController {
    @Autowired
    private SanPhamRepository spRepo;
    @Autowired
    private SanPhamChiTietRepository ctRepo;
    @Autowired
    private MauSacRepository msRepo;
    @Autowired
    private KichThuocRepository ktRepo;

    @GetMapping("index")
    public String index(
            @RequestParam(name = "page",defaultValue = "1") int pageNo,
            @RequestParam(name = "limit",defaultValue = "10") int pageSize,
            @RequestParam(name = "keyword",defaultValue = "") String keyword,
            @RequestParam(name="spId", defaultValue = "-1") int spId,
            Model model
//            , @RequestParam(name="spId", defaultValue = "-1") int spId
    ){

        model.addAttribute("spId",spId);
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        String keywordd = "%" + keyword + "%";
        Page<SPCTCustom>  ds = spId == -1 ? null : this.ctRepo.findAllWithPropNameSanPham(spId, pageable);

//        List<Spct> ds = spId == -1 ? new ArrayList<>() : this.ctRepo.findBySpId(spId);
//        List<Spct> ds = this.ctRepo.findAll();

//        PageRequest p = PageRequest.of(pageNo,pageSize);
//
//        Page<SPCTCustom> ds = this.ctRepo.findAllWithPropName(p);

//        List<SPCTCustom> ds = this.ctRepo.findAllWithPropName();

        model.addAttribute("data",ds);
        List<SanPham> dsSp = this.spRepo.findAll();
        model.addAttribute("datasp",dsSp);
//        List<MauSac> dsMs = this.msRepo.findAll();
//        model.addAttribute("datams",dsMs);

        return "spct/index";

    }

    @RequestMapping("create")
    public String create(
            Model model
    ){
        List<SanPham> dsSp = this.spRepo.findAll();
        model.addAttribute("datasp",dsSp);
        List<MauSac> dsMs = this.msRepo.findAll();
        model.addAttribute("datams",dsMs);
        List<KichThuoc> dsKt = this.ktRepo.findAll();
        model.addAttribute("datakt",dsKt);
        return "spct/create";
    }
//
    @PostMapping("store")
    public String store(
            Model model, @Valid Spct sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            List<SanPham> dsSp = this.spRepo.findAll();
            model.addAttribute("datasp",dsSp);
            List<MauSac> dsMs = this.msRepo.findAll();
            model.addAttribute("datams",dsMs);
            List<KichThuoc> dsKt = this.ktRepo.findAll();
            model.addAttribute("datakt",dsKt);
            return "spct/create";
        }else {
            this.ctRepo.save(sp);
            return "redirect:/spct/index";
        }
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        this.ctRepo.deleteById(id);
        return "redirect:/spct/index";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        Spct ms = this.ctRepo.findById(id).get();
        model.addAttribute("data",ms);
        return "spct/edit";
    }

    @PostMapping("update/{id}")
    public String update(
            Model model, @Valid Spct sp, BindingResult validateResult
    ){
        if(validateResult.hasErrors()){
            List<FieldError> listFieldError = validateResult.getFieldErrors();
            Map<String,String> error = new HashMap<>();
            for (FieldError e: listFieldError) {
                error.put(e.getField(),e.getDefaultMessage());
            }
            model.addAttribute("errors",error);
            model.addAttribute("data",sp);
            return "spct/edit";
        }else {
            this.ctRepo.save(sp);
            return "redirect:/spct/index";
        }
    }

//    @GetMapping("searchMau")
//    public String searchMau(
//            Model model,
//            @RequestParam("spId") int idSP,
//            @RequestParam("mauSac") int idMS
//    ){
//       List<Spct> ds= this.ctRepo.searchMS(idSP,idMS);
//       model.addAttribute("data",ds);
//        List<SanPham> dsSp = this.spRepo.findAll();
//        model.addAttribute("datasp",dsSp);
//        List<MauSac> dsMs = this.msRepo.findAll();
//        model.addAttribute("datams",dsMs);
//        return "spct/index";
//    }

//    @GetMapping("searchGia")
//    public String searchGia(
//            Model model,
//            @RequestParam("tu") int tu,
//            @RequestParam("den") int den
//    ){
//       List<Spct> ds= this.ctRepo.searchGia(tu,den);
//       model.addAttribute("data",ds);
//        List<SanPham> dsSp = this.spRepo.findAll();
//        model.addAttribute("datasp",dsSp);
//        List<MauSac> dsMs = this.msRepo.findAll();
//        model.addAttribute("datams",dsMs);
//        return "spct/index";
//    }
}
