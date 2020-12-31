package com.tts.PositiveVibes.repository;

import javax.validation.Valid;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.PositiveVibes.model.User;
import com.tts.PositiveVibes.model.Vibe;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

	void save(@Valid Vibe vibe);
}