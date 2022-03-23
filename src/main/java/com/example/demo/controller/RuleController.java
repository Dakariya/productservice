package com.example.demo.controller;

import com.example.demo.bean.ApiResponse;
import com.example.demo.bean.RuleForm;
import com.example.demo.bean.UserForm;
import com.example.demo.model.Rule;
import com.example.demo.service.RuleServiceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class RuleController {

  @Autowired
  private RuleServiceImpl ruleService;

  @GetMapping(value = "/{idproduct}/rules")
  public ApiResponse findRulesByProduct(@PathVariable("idproduct") Integer idproduct) {
    ApiResponse res = new ApiResponse();
    try {
      res.setData(ruleService.getRulesByProduct(idproduct));
      res.setSuccess(true);
    } catch (Exception e) {
      e.printStackTrace();
      res.setError(e.getMessage());
      res.setSuccess(false);
    }

    return res;
  }

  @PostMapping(value = "/products/{idproduct}/rules")
  public ApiResponse addRuleToProduct(@PathVariable("idproduct") Integer idproduct,
      @RequestBody RuleForm form) {
    ApiResponse res = new ApiResponse();
    try {
      ruleService.addNewRuleToProduct(idproduct, form);
      res.setSuccess(true);
    } catch (Exception e) {
      e.printStackTrace();
      res.setError(e.getMessage());
      res.setSuccess(false);
    }

    return res;
  }

  @DeleteMapping(value = "/{idproduct}/rules/{idrules}")
  public ApiResponse removeRuleToProduct(@PathVariable("idproduct") Integer idproduct,
      @PathVariable("idrules") Integer idrules) {
    ApiResponse res = new ApiResponse();
    try {
      ruleService.removeRule(idrules);
      res.setSuccess(true);
    } catch (Exception e) {
      e.printStackTrace();
      res.setError(e.getMessage());
      res.setSuccess(false);
    }

    return res;
  }

  @PostMapping(value = "/apply")
  public ApiResponse getApply(@RequestBody UserForm form) {
    ApiResponse res = new ApiResponse();
    try {
      res.setData(ruleService.getApply(form));
      res.setSuccess(true);
    } catch (Exception e) {
      e.printStackTrace();
      res.setError(e.getMessage());
      res.setSuccess(false);
    }

    return res;
  }
}
