package com.jagan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jagan.jba.entity.Item;;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	

}
