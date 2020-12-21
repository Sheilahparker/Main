package com.tts.UsersAPI.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.UsersAPI.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
List<User> findByState(String state);

List<User> findAll();
}
