package org.pt.learning.rest.request;

import javax.validation.constraints.NotNull;


public class MessageRequest{
	
	@NotNull
	private Long blogId;
	
	@NotNull
	private String message;

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
