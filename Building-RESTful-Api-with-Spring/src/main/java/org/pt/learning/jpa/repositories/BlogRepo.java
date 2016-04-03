package org.pt.learning.jpa.repositories;

import org.pt.learning.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Long> {
	
	
}
