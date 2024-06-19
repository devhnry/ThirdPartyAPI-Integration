package org.henry.thirdpartyapiintegration.controller;

import org.henry.thirdpartyapiintegration.Service.impl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class PostController {

    private PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/getPosts")
    public List<Map<String, Object>> getAllPost(){
        return postService.getPosts();
    }

    @GetMapping(path = "/getPost/{id}")
    public Map<String, Object> getPostById(@PathVariable int id){
        return postService.getPostById(id);
    }

    @PostMapping(path = "/insertPost")
    public Map<String, Object> insertPost(@RequestBody Map<String, Object> post){
        return postService.insertPost(post);
    }

    @PutMapping(path = "/updatePost/{id}")
    public Map<String, Object> updatePost(@RequestBody Map<String, Object> payload, @PathVariable int id){
        return postService.updatePost(payload, id);
    }

    @DeleteMapping(path = "/deletePost/{id}")
    public String deletePost(@PathVariable int id){
        return postService.deletePost(id);
    }
}
