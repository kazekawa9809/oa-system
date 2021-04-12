package cn.abb.oa.controller;

import cn.abb.oa.pojo.Admin;
import cn.abb.oa.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    /*@Autowired
    private AdminService adminService;


    @RequestMapping("/admin/login")
    public String adminLogin(@RequestParam("email") String adminEmail,
                             @RequestParam("password") String adminPassword) {
        String admin = adminService.adminLogin(adminEmail, adminPassword);
        System.out.println(admin);
        return "login";
    }

    @RequestMapping("/admin/info")
    public String findAllAdmin(Model model) {
        List<Admin> adminlist = adminService.selectAllAdmin();
        model.addAttribute("adminlist", adminlist);
        System.out.println("info!");
        return "admin/info";
    }

    @RequestMapping("/admin/index")
    public String index() {
        System.out.println("index!");
        return "admin/index";
    }
*/

}

