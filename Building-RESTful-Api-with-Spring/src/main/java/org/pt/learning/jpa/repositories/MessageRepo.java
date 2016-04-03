package org.pt.learning.jpa.repositories;

import java.util.List;

import org.pt.learning.entity.Blog;
import org.pt.learning.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Long> {
	
	List<Message> findByBlog(Blog blog);

}
