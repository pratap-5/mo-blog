package com.blog.blogging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;

@Configuration
public class BlogConfig {
    @Bean
    ArrayList<Blog> arrayList()
    {
        return new ArrayList<>();
    }
}
