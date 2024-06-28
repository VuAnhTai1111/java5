package com.example.demo.controllers;

import com.example.demo.repositories.assignment1.LoginRepository;
import com.example.demo.repositories.assignment2.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    NhanVienRepository nvRepo;

    @GetMapping("dangNhap")
    public String dangNhap(){
        return "login/newLogin";
    }

    @GetMapping("trangchu")
    public String trangchu (
            Model model,
            @RequestParam("tenDangNhap") String tk,
            @RequestParam("matKhau") String mk
    ){
        String a = "a";
        if (this.nvRepo.findByTenDangNhapEqualsAndMatKhauEquals(tk,mk)==null||this.nvRepo.findByTenDangNhapEqualsAndMatKhauEquals(tk,mk).equals("null")){
            String error = "Sai tài khoản hoặc mật khẩu";
            model.addAttribute("error",error);
            model.addAttribute("tk",tk);
            model.addAttribute("mk",mk);
            return "login/newLogin";
        }else if (tk.equals("admin@gmail.com") && mk.equals("123456")){
            model.addAttribute("haha",a);
            return "login/admin";
        }else {
            model.addAttribute("haha",a);
            return "login/nhanVien";
        }
    }
}
