package org.pt.learning.service;

import java.util.Date;
import java.util.List;

import org.pt.learning.entity.Blog;
import org.pt.learning.entity.Message;
import org.pt.learning.jpa.repositories.BlogRepo;
import org.pt.learning.jpa.repositories.MessageRepo;
import org.pt.learning.request.mapper.GeneralMapper;
import org.pt.learning.rest.request.BlogUpdateRequest;
import org.pt.learning.rest.request.MessageRequest;
import org.pt.learning.rest.request.MessageUpdateRequest;
import org.pt.learning.rest.response.GenericResponseBuilder;
import org.pt.learning.rest.response.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BlogService {
	
	@Autowired
	private BlogRepo blogRepo;
	
	@Autowired
	private MessageRepo messageRepo;
	
	public ResponseWrapper<Blog> addNewBlog(Blog blog){
		blog.setCreatedOn(new Date());
		blog.setUpdatedOn(new Date());
		return GenericResponseBuilder.successResponse(blogRepo.save(blog));
	}
	
	@Transactional
	public ResponseWrapper<Blog> updateBlog(BlogUpdateRequest updateRequest){
		Blog updateBlog = blogRepo.getOne(updateRequest.getId());
		updateBlog.setUpdatedOn(new Date());
		GeneralMapper.INSTANCE.updateBlogUpdateResponseToBlogEntity(updateRequest, updateBlog);
		return GenericResponseBuilder.successResponse(blogRepo.save(updateBlog));
	}
	
	@Transactional
	public ResponseWrapper<Message> addNewMessage(MessageRequest messageRequest) {
		Message message = new Message();
		Blog blog = blogRepo.getOne(messageRequest.getBlogId());
		message.setBlog(blog);
		message.setMessage(messageRequest.getMessage());
		return GenericResponseBuilder.successResponse(messageRepo.save(message));
	}
	
	@Transactional
	public ResponseWrapper<Message> updateMessage(MessageUpdateRequest updateRequest) {
		Message message = messageRepo.getOne(updateRequest.getMessageId());
		message.setMessage(updateRequest.getMessage());
		return GenericResponseBuilder.successResponse(messageRepo.save(message));
	}

	public ResponseWrapper<List<Blog>> findAllBlogs() {
		System.out.println(blogRepo.findAll());
		return GenericResponseBuilder.successResponse(blogRepo.findAll());
	}

	public ResponseWrapper<Blog> findOneBlog(Long blogId) {
		System.out.println(blogRepo.findOne(blogId));
		return GenericResponseBuilder.successResponse(blogRepo.findOne(blogId));
	}

	public ResponseWrapper<Message> findOneMessage(Long messageId) {
		System.out.println(messageRepo.findOne(messageId));
		return GenericResponseBuilder.successResponse(messageRepo.findOne(messageId));
	}
	
	
	public ResponseWrapper<List<Message>> findAllBlogMessage(Long blogId) {
		Blog blog = blogRepo.getOne(blogId);
		System.out.println(messageRepo.findByBlog(blog));
		return GenericResponseBuilder.successResponse(messageRepo.findByBlog(blog));
	}
	

}
