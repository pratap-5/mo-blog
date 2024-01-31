package com.blog.blogging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BlogController {

    
    //creating  the list of Blog object
    // @Autowired
    private  final  BlogService blogService;



    
    // public void setBlogService(BlogService blogService)
    // {
    //     this.blogService=blogService;
    // }

    //here the mappings of the requests 

    @GetMapping({"/","/blogs"})
    public String blogs(Model model){
        model.addAttribute("blogs",blogService.getBlogs());
        return "blogs";
    }
    @GetMapping("/blog")
    public String blog(@RequestParam  int id ,Model model)
    {
        var blog =blogService.getBlog(id);
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
        blogService.addBlog(blog);
        return "redirect:/blogs";
    }
    

}
