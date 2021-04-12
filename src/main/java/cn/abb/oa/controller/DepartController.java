package cn.abb.oa.controller;

import cn.abb.oa.pojo.Depart;
import cn.abb.oa.pojo.User;
import cn.abb.oa.service.DepartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/depart")
public class DepartController {

    @Autowired
    private DepartService departService;

    @GetMapping("/add")
    public String add(){
        return "admin/addDepart";
    }

    @PostMapping("/addInfo")
    public String addDepart(@RequestParam("departName") String departName,
                            @RequestParam("departTel") String departTel,
                            @RequestParam("departDescription") String departDescription,
                            @RequestParam("departLocation") String departLocation,
                            @RequestParam("departUpperId") long departUpperId,
                            @RequestParam("departManagerId") long departManagerId){
        Depart depart = new Depart(departName,departTel,departDescription,departLocation,departUpperId,departManagerId);
        departService.addInfo(depart);
        System.out.println("add announce!");
        return "redirect:/depart/allDepart";
    }

    @RequestMapping("/delete/{departId}")
    public String deleteDepart(@PathVariable long departId) {
        departService.deleteInfo(departId);
        return "redirect:/depart/allDepart";
    }

    @GetMapping("/info/{departId}")
    @ApiOperation("为更新部门提供信息")
    public String departInfo(@PathVariable("departId") long departId, Model model) {
        Depart depart = departService.selectDepartById(departId);
        model.addAttribute("updateDepartInfo",depart);
        System.out.println("depart info!");
        return "admin/updateDepart";
    }


    @RequestMapping("/update")
    public String updateDepart(Depart depart) {
        departService.updateInfo(depart);
        return "redirect:/depart/allDepart";
    }

    @GetMapping("/allDepart")
    @ApiOperation("所有部门")
    public String selectAllDepart(Model model) {
        List<Depart> departList = departService.selectAllDepart();
        model.addAttribute("departList", departList);
        return "admin/allDepart";
    }

}
