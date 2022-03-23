package com.example.demo.repository;

import com.example.demo.bean.UserForm;
import com.example.demo.model.Product;
import java.util.Set;

public interface RuleRepositoryCustom {
  Set<Product> getApply(UserForm form);

}
