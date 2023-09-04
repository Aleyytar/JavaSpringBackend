package com.example.ReactDilrb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ReactDilrb.entities.Post;
import com.example.ReactDilrb.entities.User;
import com.example.ReactDilrb.repos.PostRepository;
import com.example.ReactDilrb.request.forposts.PostCreateRequesy;
import com.example.ReactDilrb.request.forposts.PostUpdateRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {
	
	private PostRepository postRepository;
	private UserService userService;


	public List<Post> getAllPost(Optional<Long> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId);
		return postRepository.findAll();
	}


	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}


	public Post createOnePost( PostCreateRequesy newPostRequest) {
		User user = userService.getOneUser(newPostRequest.getUserId());
		if(user == null)
			return null;
		Post toSave =  new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		return postRepository.save(toSave);
	}


	

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
		
	}


	public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(postUpdateRequest.getText() );
			toUpdate.setTitle(postUpdateRequest.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}


	
	

	

}
