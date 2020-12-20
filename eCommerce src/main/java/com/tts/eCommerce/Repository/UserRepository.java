package com.tts.eCommerce.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.eCommerce.model.User;


@Repository
	public interface UserRepository extends CrudRepository<User, Long> {
		User findByUsername(String username);
	}
