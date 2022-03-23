package com.example.demo.service;

import com.example.demo.bean.RuleForm;
import com.example.demo.bean.UserForm;
import com.example.demo.model.Product;
import com.example.demo.model.Rule;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.RuleRepository;
import com.example.demo.repository.RuleRepositoryCustom;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService{
  @Autowired
  private RuleRepository ruleRepository;
  @Autowired
  ProductRepository productRepository;


  @Override
  public List<Rule> getRulesByProduct(Integer idproduct) {
    return ruleRepository.findListByProductId(idproduct);
  }

  @Override
  public void removeRule(Integer idrules) {
    Rule rule = ruleRepository.findByRuleId(idrules);
    if (rule != null) {
      ruleRepository.delete(rule);
    }
  }

  @Override
  public Set<Product> getApply(UserForm form) {
    return productRepository.getApply(form);
  }

  @Override
  public void addNewRuleToProduct(Integer idproduct, RuleForm ruleForm) {
    Product product = productRepository.findByProductId(idproduct);
    if (product == null) {
      return  ;
    }

    Rule newRule = new Rule();
    newRule.set_debtor(ruleForm.is_debtor());
    newRule.setProduct(product);
    newRule.setIdrules(ruleForm.getIdrules());
    newRule.setSalary(ruleForm.getSalary());
    ruleRepository.save(newRule);
  }


}
