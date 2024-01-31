package com.blog.blogging;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    
    private final List<Blog> blogs;

    public void addBlog(Blog blog)
    {
        blogs.add(blog);
    }

    public List<Blog>getBlogs()
    {
        return blogs;
    }
    public Blog getBlog(int index)
    {
        return blogs.get(index);
    }
}
