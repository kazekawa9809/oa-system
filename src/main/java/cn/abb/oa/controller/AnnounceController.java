package cn.abb.oa.controller;

import cn.abb.oa.pojo.Announce;
import cn.abb.oa.pojo.User;
import cn.abb.oa.service.AnnounceService;
import cn.abb.oa.utils.string2date;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/announce")
public class AnnounceController {

    @Autowired
    private AnnounceService announceService;

    @GetMapping("/add")
    public String add(){
        return "admin/addAnnounce";
    }

    @RequestMapping("/addInfo")
    public String addAnnounce(@RequestParam("announceTitle") String announceTitle,
                              //@RequestParam("announceCover") String announceCover,
                              @RequestParam("announceContent") String announceContent,
                              @RequestParam("announceCreator") Long announceCreator) throws ParseException {
        Announce announce = new Announce(null,announceTitle,null,announceCreator,announceContent, new Date(),null);
        announceService.addInfo(announce);
        System.out.println("add announce!");
        return "redirect:/announce/allInfo";
    }

    @RequestMapping("/delete/{announceId}")
    public String deleteAnnounce(@PathVariable long announceId) {
        announceService.deleteInfo(announceId);
        return "redirect:/announce/allInfo";
    }

    @GetMapping("/info/{announceId}")
    @ApiOperation("为更新公告提供信息")
    public String announceInfo(@PathVariable("announceId") long announceId, Model model) {
        Announce announce = announceService.selectAnnounceById(announceId);
        model.addAttribute("updateAnnounceInfo",announce);
        System.out.println("announce info!");
        return "admin/announceInfo";
    }

    @RequestMapping("/update")
    public String updateAnnounce(Announce announce) {
        announceService.updateInfo(announce);
        return "redirect:/announce/allInfo";
    }

    @RequestMapping("/allInfo")
    @ApiOperation("所有公告信息")
    public String selectAllAnnounce(Model model) {
        List<Announce> announceList = announceService.selectAllAnnounce();
        model.addAttribute("announceList", announceList);
        return "admin/allAnnounce";
    }

}

