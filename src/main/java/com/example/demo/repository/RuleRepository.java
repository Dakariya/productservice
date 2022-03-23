package com.example.demo.repository;

import com.example.demo.bean.UserForm;
import com.example.demo.model.Product;
import com.example.demo.model.Rule;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Integer>{


  @Query("select r from Rule r join r.product p where p.idproduct = ?1")
  List<Rule> findListByProductId(Integer idproduct);

  @Query("select r from Rule r where r.idrules = ?1")
  Rule findByRuleId(Integer idrules);


}
