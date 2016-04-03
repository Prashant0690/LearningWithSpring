package org.pt.learning.controller;

import java.util.List;

import javax.validation.Valid;

import org.pt.learning.entity.Blog;
import org.pt.learning.entity.Message;
import org.pt.learning.request.mapper.GeneralMapper;
import org.pt.learning.rest.request.BlogRequest;
import org.pt.learning.rest.request.BlogUpdateRequest;
import org.pt.learning.rest.request.MessageRequest;
import org.pt.learning.rest.request.MessageUpdateRequest;
import org.pt.learning.rest.response.ResponseWrapper;
import org.pt.learning.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/blogger")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping (value="/add/blog", method=RequestMethod.POST, 
			consumes="application/json", produces="application/json")
	public ResponseWrapper<Blog> addBlog(@Valid  @RequestBody BlogRequest blogRequest){
		
		return blogService.addNewBlog(GeneralMapper.INSTANCE.requestToEntity(blogRequest));
	}
	
	@RequestMapping (value="/update/blog", method=RequestMethod.POST, 
			consumes = "application/json", produces="application/json")
	public ResponseWrapper<Blog> updateBlog(@Valid @RequestBody BlogUpdateRequest updateRequest){
		return blogService.updateBlog(updateRequest);
	}
	
	@RequestMapping (value="/add/messsage/", method=RequestMethod.POST, 
			consumes = "application/json", produces="application/json")
	public ResponseWrapper<Message> addMessage(@Valid @RequestBody MessageRequest messageRequest){
		return blogService.addNewMessage(messageRequest);
	}
	
	@RequestMapping (value="/update/messsage/", method=RequestMethod.POST, 
			consumes = "application/json", produces="application/json")
	public ResponseWrapper<Message> updateMessage(@Valid @RequestBody MessageUpdateRequest updateRequest){
		return blogService.updateMessage(updateRequest);
	}
	
	@RequestMapping (value="/find/all/blogs", method=RequestMethod.POST, produces="application/json")
	public ResponseWrapper<List<Blog>> findAll(){
		return blogService.findAllBlogs();
	}
	
	@RequestMapping (value="/find/one/blog/{blogId}", method=RequestMethod.POST, produces="application/json")
	public ResponseWrapper<Blog> findOneBlogById(@PathVariable Long blogId){
		return blogService.findOneBlog(blogId);
	}
	
	@RequestMapping (value="/find/one/message/{messageId}", method=RequestMethod.POST, produces="application/json")
	public ResponseWrapper<Message> findOneMessageById(@PathVariable Long messageId){
		return blogService.findOneMessage(messageId);
	}
	
	@RequestMapping (value="/find/all/blog/message/{blogId}", method=RequestMethod.POST, produces="application/json")
	public ResponseWrapper<List<Message>> findAllBlogMessageByBlogId(@PathVariable Long blogId){
		return blogService.findAllBlogMessage(blogId);
	}
	
	

}
