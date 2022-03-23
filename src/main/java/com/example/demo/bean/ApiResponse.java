package com.example.demo.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
  boolean success;
  Object data;
  String error;

}
