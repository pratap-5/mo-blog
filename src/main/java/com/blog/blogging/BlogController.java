package com.blog.blogging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {

    
    //creating  the list of Blog object
    private final List<Blog>blogs;
    public BlogController()
    {
        blogs=new ArrayList<>();
    }
    

    //here the mappings of the requests 

    @GetMapping({"/","/blogs"})
    public String blogs(Model model){
        model.addAttribute("blogs",blogs);
        return "blogs";
    }
    @GetMapping("/blog")
    public String blog(@RequestParam  int id ,Model model)
    {
        var blog=blogs.get(id);
        model.addAttribute("blog", blog);
        return "blog";
    }
    @GetMapping("/add-blog")
    public String addBlog()
    {
        return "add-blog";
    }

    @PostMapping("/add-blog")
    public String postMethodName(@ModelAttribute Blog blog) {
        blogs.add(blog);
        return "redirect:/blogs";
    }
    

}
