package cn.abb.oa.controller;

import cn.abb.oa.pojo.Admin;
import cn.abb.oa.pojo.User;
import cn.abb.oa.service.AdminService;
import cn.abb.oa.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password,
                        @RequestParam("kind") String kind , Model model , HttpSession session) {
        System.out.println(email+password+kind);
        if ( kind.equals("admin")){ session.setAttribute("isAdmin",true);}
        else   { session.setAttribute("isAdmin",false);}
        if (kind.equals("admin")) {
            System.out.println("我是管理员");
            Admin admin = adminService.selectAdminByEmail(email);
            if ((admin == null) || (!admin.getAdminPassword().equals(password))) {
                session.setAttribute("msg", "用户未注册或账号密码错误");
                return "login";
            } else {
                session.setAttribute("admin", admin);
                return "index";
            }
        } else {
            System.out.println("我是普通用户");
            User user = userService.selectUserByEmail(email);
            if ((user == null) || (!user.getUserPassword().equals(password))) {
                session.setAttribute("msg", "用户未注册或账号密码错误");
                return "login";
            } else {
                session.setAttribute("user", user);
                return "index";
            }
        }
    }
/*    @RequestMapping("/basic")
    public String basic(Model model){
        UserVo userVo = new UserVo();
        userVo.setUsername("abb");
        userVo.setAge(22);
        userVo.setSex(1);
        userVo.setIsVip(true);
        userVo.setCreateTime(new Date());
        userVo.setTags(Arrays.asList("java","py","c++"));
        model.addAttribute("user",userVo);
        return "basic";
    }*/
}

