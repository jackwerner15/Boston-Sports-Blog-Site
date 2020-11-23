package com.tts.finalproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tts.finalproject.model.BlogPost;
import com.tts.finalproject.repository.BlogPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogPostController {

	@Autowired
	private BlogPostRepository blogPostRepository;
	

	private List<BlogPost> posts = new ArrayList<>();
    

	@GetMapping(value = "/")
	public String index(BlogPost blogPost, Model model) {
		
		return "blogpost/index";
	}
	
    

	@GetMapping(value = "/blogpost/new")
	public String newBlog(BlogPost blogPost) {
		posts.removeAll(posts);
		return "blogpost/new";
	}
	

    
    @GetMapping(value = "/blogpost/patriots")
	public String newPatsBlog(BlogPost blogPost, Model model){
		posts.removeAll(posts);
		for (BlogPost postFromDB : blogPostRepository.findAll()) {
			if (postFromDB.getTypeof().equals("patriots") ){
			posts.add(postFromDB);
			} 
		}
		model.addAttribute("posts", posts);
		return "blogpost/patriots";
	}



	@RequestMapping("/teampic/pats")
	public String  teamPicPats(){
	return "teampic/pats";
	}


	
	@GetMapping(value = "/blogpost/redsox")
	public String newSoxBlog(BlogPost blogPost, Model model) {
		posts.removeAll(posts);
		for (BlogPost postFromDB : blogPostRepository.findAll()) {
			if (postFromDB.getTypeof().equals("red sox") ){
			posts.add(postFromDB);
			} 
		}
		model.addAttribute("posts", posts);
		return "blogpost/redsox";
		
	}



	@RequestMapping("/teampic/sox")
	public String  teamPicSox(){
	return "teampic/sox";
	}



	@GetMapping(value = "/blogpost/bruins")
	public String newBruinsBlog(BlogPost blogPost, Model model) {
		posts.removeAll(posts);
		for (BlogPost postFromDB : blogPostRepository.findAll()) {
			if (postFromDB.getTypeof().equals("bruins") ){
			posts.add(postFromDB);
			} 
		}
		model.addAttribute("posts", posts);
		return "blogpost/bruins";
		
	}



	@RequestMapping("/teampic/bs")
	public String  teamPicBs(){
	return "teampic/bs";
	}



	
	@GetMapping(value = "/blogpost/celtics")
	public String newCelticsBlog(BlogPost blogPost, Model model) {
		posts.removeAll(posts);
		for (BlogPost postFromDB : blogPostRepository.findAll()) {
			if (postFromDB.getTypeof().equals("celtics") ){
			posts.add(postFromDB);
			} 
		}
		model.addAttribute("posts", posts);
		return "blogpost/celtics";
		
	}



	@RequestMapping("/teampic/cs")
	public String  teamPicCs(){
	return "teampic/cs";
	}



	@RequestMapping("/teampic/about")
	public String  aboutSlide(){
	return "teampic/about";
	}




	@PostMapping(value = "/blogpost")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		
		blogPostRepository.save(blogPost);

		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogentry", blogPost.getBlogentry());
		model.addAttribute("blogtypeof", blogPost.getTypeof());
		return "blogpost/result";
	}



	@PostMapping(value= "/blogpost/update/{id}")
	public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model){
		Optional<BlogPost> post = blogPostRepository.findById(id);
		if (post.isPresent()) {
            BlogPost actualPost = post.get();
            actualPost.setTitle(blogPost.getTitle());
            actualPost.setAuthor(blogPost.getAuthor());
			actualPost.setBlogentry(blogPost.getBlogentry());
			actualPost.setTypeof(blogPost.getTypeof());
            blogPostRepository.save(actualPost);
            model.addAttribute("blogPost", actualPost);
        } else{

		}
 
        return "blogpost/result";
	}





	@RequestMapping(value = "/blogpost/blogpost/delete/{id}")
	public String deletePostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
		blogPostRepository.deleteById(id);

		return "blogpost/delete";
    }
	
	









	


	@RequestMapping(value = "/blogpost/edit/{id}")
	public String editPostWithId(@PathVariable Long id, Model model) {
		Optional<BlogPost> editPost = blogPostRepository.findById(id);

		
		BlogPost result = null;

		
		if (editPost.isPresent()) {
			
			result = editPost.get();
			
			model.addAttribute("blogPost", result);
		} else {
			
			return "Error";
		}

		
		return "blogpost/edit";
	}

	

}


