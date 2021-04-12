package cn.abb.oa.controller;

import cn.abb.oa.pojo.User;
import cn.abb.oa.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allInfo")
    @ApiOperation("获取所有用户列表")
    public String userAllInfo(Model model) {
        List<User> userList = userService.selectAllUser();
        model.addAttribute("userList", userList);
        return "user/allInfo";
    }

    @GetMapping("/info/{userId}")
    @ApiOperation("为更新员工提供信息")
    public String userInfo(@PathVariable("userId") long userId, Model model) {
        User user = userService.selectUserById(userId);
        model.addAttribute("updateUserInfo",user);
        System.out.println("user info!");
        return "user/update";
    }

    @GetMapping("/add")
    public String add(){
        return "user/addInfo";
    }

    @PostMapping("/addInfo")
    public String addUser(
                          @RequestParam("userName") String userName,
                          @RequestParam("userTel") String userTel,
                          @RequestParam("userEmail") String userEmail,
                          @RequestParam("userLevel") long userLevel,
                          @RequestParam("userDepartId") long userDepartId,
                          @RequestParam("userDepartId") long userUpperId,
                          @RequestParam("userPositionId") long userPositionId){
        User user = new User(null,userName,userTel,userEmail,"123456",userDepartId,
                userPositionId,userUpperId,userLevel);
        userService.addUser(user);
        return "redirect:/user/allInfo";
    }

    @PostMapping("/update")
    @ApiOperation("更新员工")
    public String update(@RequestParam("userId") long userId,
                         @RequestParam("userName") String userName,
                         @RequestParam("userTel") String userTel,
                         @RequestParam("userEmail") String userEmail,
                         @RequestParam("userPassword") String userPassword,
                         @RequestParam("userLevel") long userLevel,
                         @RequestParam("userDepartId") long userDepartId,
                         @RequestParam("userDepartId") long userUpperId,
                         @RequestParam("userPositionId") long userPositionId){
        User user = new User(userId,userName,userTel,userEmail,userPassword,userDepartId,
                userPositionId,userUpperId,userLevel);

        userService.updateUser(user);
        return "redirect:/user/allInfo";
    }

    @RequestMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") long userId){
        userService.deleteUserById(userId);
        System.out.println(userId+" deleted!");
        return "redirect:/user/allInfo";
    }

    @RequestMapping("/user/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/user/logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
