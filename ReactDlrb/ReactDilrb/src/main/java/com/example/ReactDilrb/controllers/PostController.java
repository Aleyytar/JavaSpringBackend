package com.example.ReactDilrb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReactDilrb.entities.Post;
import com.example.ReactDilrb.request.forposts.PostCreateRequesy;
import com.example.ReactDilrb.request.forposts.PostUpdateRequest;
import com.example.ReactDilrb.services.PostService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
	
	private PostService postService;
	
	
	@GetMapping("getall")
	public List<Post> getAllPost(@RequestParam Optional<Long> userId){
		return postService.getAllPost(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable Long postId) {
		return postService.getOnePostById(postId);  
		 
	}
	
	@PostMapping("add")
	public Post createOnePost(@RequestBody PostCreateRequesy newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post uptadeOnePost(@PathVariable Long postId , @RequestBody PostUpdateRequest postUpdateRequest) {
		return postService.updateOnePostById(postId, postUpdateRequest);
		
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePostById(postId);
	}

}
