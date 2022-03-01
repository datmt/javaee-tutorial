package com.logging.spring.hikari_error.controller;

import com.logging.spring.hikari_error.dto.UserDto;
import com.logging.spring.hikari_error.model.User;
import com.logging.spring.hikari_error.repository.UserRepository;
import com.logging.spring.hikari_error.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  UserService userService;

  @PostMapping()
  public User create(@RequestBody UserDto userDto) {
    User user = new User();
    user.setId(userDto.getId());
    user.setName(userDto.getName());
    return userRepository.save(user);
  }


  @GetMapping()
  public List<User> get() {
    return userRepository.findAll();
  }


  @GetMapping("leak/{id}")
  public User getLeak(@PathVariable Long id) throws SQLException, InterruptedException {
    return userService.updateUser(id);
  }
}
