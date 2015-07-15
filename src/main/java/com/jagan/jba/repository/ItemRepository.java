package com.jagan.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jagan.jba.entity.Blog;
import com.jagan.jba.entity.Item;;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByBlog(Blog blog);

}
