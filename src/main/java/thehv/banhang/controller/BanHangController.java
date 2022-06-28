package thehv.banhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BanHangController {

    @GetMapping("/hoadonnhap")
    public String hoadonnhap() {
        return "hoadonnhap";
    }

    @GetMapping("/hoadonnhapct")
    public String hoadonnhapct(@RequestParam(required = false) String ma) {
        return "hoadonnhapct";
    }

    @GetMapping("/hoadonxuat")
    public String hoadonxuat() {
        return "hoadonxuat";
    }

    @GetMapping("/hoadonxuatct")
    public String hoadonxuatct(@RequestParam(required = false) String ma, @RequestParam(required = false) Integer v) {
        if (v != null && v == 1) {
            return "hoadonxuatct_v";
        }
        return "hoadonxuatct";
    }

    @GetMapping("/mathang")
    public String mathang() {
        return "mathang";
    }

    @GetMapping("/mathangct")
    public String mathangct(@RequestParam(required = false) String ma) {
        return "mathangct";
    }

    @GetMapping("/nhacc")
    public String nhacc() {
        return "nhacc";
    }

    @GetMapping("/xuatnhapton")
    public String xuatnhapton() {
        return "xuatnhapton";
    }
}