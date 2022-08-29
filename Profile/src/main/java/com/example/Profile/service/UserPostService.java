package com.example.Profile.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Profile.dto.UserLikePostDTO;
import com.example.Profile.model.Post;
import com.example.Profile.model.Profile;
import com.example.Profile.model.User;
import com.example.Profile.model.UserPost;
import com.example.Profile.repository.UserPostRepository;
import com.example.Profile.repository.UserRepository;

@Service
public class UserPostService {

	@Autowired
	private UserPostRepository userPostRepository;
	
	@Autowired
	private UserService userService;
	
	public UserPost save(UserPost post) {
		Long last_id=(long)0;
		List<UserPost> allUserPosts=this.userPostRepository.findAll();
		for (UserPost userPost : allUserPosts) {
			if(post.getLinks().equals(userPost.getLinks()) & post.getPicture().equals(userPost.getPicture()) & post.getText().equals(userPost.getText())) {
				post.setId(userPost.getId());
				return this.userPostRepository.save(post);
			}
			last_id=userPost.getId();
		}
		
		last_id=last_id+1;
		post.setId(last_id);
		return this.userPostRepository.save(post);
	}
	public List<UserPost> findAllPostsByUser(Long id){
		List<UserPost> allPosts=this.userPostRepository.findAll();
		List<UserPost> posts=new ArrayList<>();
		for (UserPost post : allPosts) {
			if(post.getUser().getId()==id) {
				posts.add(post);
			}
		}
		return posts;
	}
	public UserPost findById(Long id) {
		Optional<UserPost> opt = this.userPostRepository.findById(id);
		if (!opt.isPresent()) {
			return null;
		} else
		{
			return opt.get();
		}
	}
	public boolean isUserAlreadyLike(UserLikePostDTO dto) {
		UserPost post=this.findById(dto.getUserPost().getId());
		if(post.getUserWhoLiked()==null) {
			return false;
		}
		for (Long userId : post.getUserWhoLiked()) {
			if (userId==dto.getUserId()) {
				return true;
			}
		}
		return false;
	}
	
	public UserPost likePost(UserLikePostDTO dto) {
		if(!this.isUserAlreadyLike(dto) && !this.isUserAlreadyDislike(dto)) {
			UserPost post=this.findById(dto.getUserPost().getId());
			//ako je lista ljudi koji su lajkovali prszna, potrebna je provera, ne moze se samo dodati
			if(post.getUserWhoLiked()==null) {
				List<Long> initial=new ArrayList<>();
				initial.add(dto.getUserId());
				post.setUserWhoLiked(initial);
			}else {
				post.getUserWhoLiked().add(dto.getUserId());
			}
			
			post.setLikes(post.getLikes()+1);
			return this.userPostRepository.save(post);
		}else if (this.isUserAlreadyDislike(dto)) {
			UserPost post=this.findById(dto.getUserPost().getId());
			post.setDislikes(post.getDislikes()-1);
			post.getUserWhoDisliked().remove(dto.getUserId());
			
			if(post.getUserWhoLiked()==null) {
				List<Long> initial=new ArrayList<>();
				initial.add(dto.getUserId());
				post.setUserWhoLiked(initial);
			}else {
				post.getUserWhoLiked().add(dto.getUserId());
			}
			post.setLikes(post.getLikes()+1);
			return this.userPostRepository.save(post);
		}
		
		return null;
	}
	public boolean isUserAlreadyDislike(UserLikePostDTO dto) {
		UserPost post=this.findById(dto.getUserPost().getId());
		if(post.getUserWhoDisliked()==null) {
			return false;
		}
		for (Long userId : post.getUserWhoDisliked()) {
			if (userId==dto.getUserId()) {
				return true;
			}
		}
		return false;
	}
	
	public UserPost dislikePost(UserLikePostDTO dto) {
		if(!this.isUserAlreadyDislike(dto) && !this.isUserAlreadyLike(dto)) {
			UserPost post=this.findById(dto.getUserPost().getId());
			if(post.getUserWhoDisliked()==null) {
				List<Long> initial=new ArrayList<>();
				initial.add(dto.getUserId());
				post.setUserWhoDisliked(initial);
			}else {
				post.getUserWhoDisliked().add(dto.getUserId());
			}
			
			post.setDislikes(post.getDislikes()+1);
			return this.userPostRepository.save(post);
		}else if(this.isUserAlreadyLike(dto)) {
			UserPost post=this.findById(dto.getUserPost().getId());
			post.setLikes(post.getLikes()-1);
			post.getUserWhoLiked().remove(dto.getUserId());
			
			if(post.getUserWhoDisliked()==null) {
				List<Long> initial=new ArrayList<>();
				initial.add(dto.getUserId());
				post.setUserWhoDisliked(initial);
			}else {
				post.getUserWhoDisliked().add(dto.getUserId());
			}
			post.setDislikes(post.getDislikes()+1);
			return this.userPostRepository.save(post);
		}
		return null;
	}
	
	public List<UserPost> allUserPostFromUsersWhoFollowedByUser(Long userId){
		
		User loginUser=this.userService.findById(userId);
		List<UserPost> allpost=new ArrayList<>();
		
		for (String username : loginUser.getFollowing()) {
			User user=this.userService.findByUsername(username);
			List<UserPost> allPostByUser=this.findAllPostsByUser(user.getId());
			for (UserPost userPost : allPostByUser) {
				allpost.add(userPost);
			}
		}
		return allpost;
	}
	
}
