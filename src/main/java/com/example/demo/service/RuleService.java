package com.example.demo.service;

import com.example.demo.bean.RuleForm;
import com.example.demo.bean.UserForm;
import com.example.demo.model.Product;
import com.example.demo.model.Rule;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public interface RuleService {
  void addNewRuleToProduct(Integer idproduct, RuleForm ruleForm);
  List<Rule> getRulesByProduct(Integer idproduct);
  void removeRule(Integer idrules);

  Set<Product> getApply(UserForm form);
}
