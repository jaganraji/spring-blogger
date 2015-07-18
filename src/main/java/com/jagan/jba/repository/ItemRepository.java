package com.jagan.jba.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jagan.jba.entity.Blog;
import com.jagan.jba.entity.Item;
import com.jagan.jba.entity.Role;


public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog, Pageable pageable);




	

}
