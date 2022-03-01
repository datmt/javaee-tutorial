package com.logging.spring.hikari_error.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Slf4j
public class TestLog {

  @GetMapping
  public void log1( ) {
    log.debug("You called me");
  }
}
