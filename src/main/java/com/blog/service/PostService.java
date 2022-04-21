package com.blog.service;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payloads.PostDto;

public interface PostService {

	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	PostDto updatePost(PostDto postDto, Integer postId);

	// delete
	void deletePost(Integer postId);

	// get all posts
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);

	// get single post
	PostDto getPostById(Integer postId);

	// get all posts by user
	List<PostDto> getPostsByUser(Integer userId);

	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// search posts
	List<Post> searchPosts(String keyword);
}
