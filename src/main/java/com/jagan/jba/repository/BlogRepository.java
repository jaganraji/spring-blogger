package com.jagan.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jagan.jba.entity.Blog;
import com.jagan.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	List<Blog> findByUser(User user);

}
