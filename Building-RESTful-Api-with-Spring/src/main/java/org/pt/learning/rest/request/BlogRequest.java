package org.pt.learning.rest.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.pt.learning.enums.Status;

public class BlogRequest {
	
	@NotNull
	@Length (max=100)
	private String title;
	
	//private List<MessageRequest> messages; 
	@NotNull
	private Status status;
	
	@NotNull
	@Length (max=50)
	private String author;
	
	@NotNull
	@Email
	private String email;
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/*public List<MessageRequest> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageRequest> messages) {
		this.messages = messages;
	}*/

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		
}
