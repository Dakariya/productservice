package com.example.demo.controller;

import com.example.demo.model.Rule;
import com.example.demo.service.ProductServiceImpl;
import com.example.demo.service.RuleServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private ProductServiceImpl productService;


  @GetMapping("/products")
  public List getAll(){
    return productService.findAll();
  }


}
