package com.logging.spring.hikari_error.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
  private final Long id;
  private final String name;
}
