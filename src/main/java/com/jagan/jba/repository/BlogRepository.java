package com.jagan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jagan.jba.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{
	

}
