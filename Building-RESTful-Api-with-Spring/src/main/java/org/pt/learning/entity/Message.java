package org.pt.learning.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="MESSAGE")
public class Message implements Serializable{
	
	@Id
	@GeneratedValue
	@Column (name="ID")
	private Long id;
	
	@Lob
	@Column (name="MESSAGE",length=2000)
	private String message;
	
	@ManyToOne
	@JoinColumn (name = "BLOG_ID", nullable=false)
	private Blog blog;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append(", blog=");
		builder.append(blog);
		builder.append("]");
		return builder.toString();
	}
	
}
