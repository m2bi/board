package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @Autowired
    private final PostRepository postRepository;

    public HelloWorldController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "post/list";
    }

    @GetMapping("/add")
    public String getAddPostForm() {
        return "addform";
    }

    @PostMapping("/add")
    public String addPost(Post post) {
        postRepository.save(post);
        return "redirect:/posts";
    }
}
