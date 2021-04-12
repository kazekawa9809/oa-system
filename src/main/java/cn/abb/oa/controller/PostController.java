package cn.abb.oa.controller;

import cn.abb.oa.pojo.Post;
import cn.abb.oa.pojo.User;
import cn.abb.oa.service.PostService;
import cn.abb.oa.service.impl.PostServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/add")
    public String add(){
        return "admin/addPost";
    }

    @PostMapping("/addInfo")
    @ApiOperation("增加职位信息")
    public String addInfo(
                              @RequestParam("postName") String postName,
                              @RequestParam("postDescription") String postDescription) {
        Post post = new Post(null,postName,postDescription);
        postService.addInfo(post);
        System.out.println("add post!");
        return "redirect:/post/allPost";
    }

    @RequestMapping("/delete/{postId}")
    @ApiOperation("删除职位")
    public String delete(@PathVariable Long postId) {
        postService.deleteInfo(postId);
        return "redirect:/post/allPost";
    }

    @GetMapping("/info/{postId}")
    @ApiOperation("为更新员工提供信息")
    public String postInfo(@PathVariable("postId") long postId, Model model) {
        Post post = postService.selectPositionById(postId);
        model.addAttribute("updatePostInfo",post);
        System.out.println(post);
        return "admin/updatePost";
    }

    @RequestMapping("/update")
    @ApiOperation("更新职位")
    public String updatePost(@RequestParam("postId") long postId,
                             @RequestParam("postName") String postName,
                             @RequestParam("postDescription") String postDescription) {
        Post post = new Post(postId,postName,postDescription);
        postService.updateInfo(post);
        return "redirect:/post/allPost";
    }

    @RequestMapping("/allPost")
    @ApiOperation("查找所有职位")
    public String selectAllPost(Model model) {
        List<Post> positionList = postService.selectAllPosition();
        model.addAttribute("positionList", positionList);
        return "admin/allPost";
    }
}
