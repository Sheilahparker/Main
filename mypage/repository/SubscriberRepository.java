package com.tts.mypage.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.mypage.domain.Subscriber;

public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {
	

}
