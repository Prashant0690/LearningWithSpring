package org.pt.learning.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.pt.learning.enums.Status;

@Entity
@Table (name="BLOG")
public class Blog implements Serializable {
	
	@Id
	@GeneratedValue
	@Column (name="ID")
	private Long id;
	
	@Column (name="TITLE", length=100, nullable=false)
	private String title;
	
	@OneToMany(mappedBy="blog" ,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Message> messages; 
	
	@Column (name="STATUS")
	private Status status;
	
	@Column (name="AUTHOR", length=50, nullable=false)
	private String author;
	
	@Column (name="EMAIL", nullable=false)
	private String email;

	@Temporal (TemporalType.DATE)
	@Column (name="CREATED_ON")
	private Date createdOn;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name="UPDATED_ON")
	private Date updatedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Blog [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", messages=");
		builder.append(messages);
		builder.append(", status=");
		builder.append(status);
		builder.append(", author=");
		builder.append(author);
		builder.append(", email=");
		builder.append(email);
		builder.append(", createdOn=");
		builder.append(createdOn);
		builder.append(", updatedOn=");
		builder.append(updatedOn);
		builder.append("]");
		return builder.toString();
	}
	
}
