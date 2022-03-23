package com.example.demo.repository;

import com.example.demo.bean.UserForm;
import com.example.demo.model.Product;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findAll();
  @Query("select p from Product p where p.idproduct = ?1")
  Product findByProductId(Integer idproduct);

  @Query("select p from Product p where p.claim = ?1")
  Set<Product> getApply(UserForm form);
}
