package com.jagan.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jagan.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	

}
