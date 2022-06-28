package thehv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/header")
    public String header() {
        return "header";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/vms-home")
    public String vmsHome() {
        return "vms-home";
    }

    @GetMapping("/vms-iconnect")
    public String vmsIconnect() {
        return "vms-iconnect";
    }

    @GetMapping("/vms-naptherinhqua")
    public String vmsNapTheRinhQua() {
        return "vms-naptherinhqua";
    }
}