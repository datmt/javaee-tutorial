package com.logging.spring.hikari_error.service;

import com.logging.spring.hikari_error.model.User;
import com.logging.spring.hikari_error.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Slf4j
public class UserService {

  @Autowired
  UserRepository userRepository;


  @Transactional
  public User updateUser(Long id) throws InterruptedException {
    User user = userRepository.findById(id).orElse(null);

    if (user == null) {
      log.info("user is null");
      return null;
    }


    log.info("user is OK");
    Thread.sleep(2000);

    user.setName(user.getName() + " hihi");

    Thread.sleep(2000);

    return userRepository.save(user);

  }
}
