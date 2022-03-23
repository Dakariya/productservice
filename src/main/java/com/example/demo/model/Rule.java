package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "rules")
@Getter
@Setter
@ToString
public class Rule {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "identity")
  private Long identity;

  @Column(name = "idrules")
  private int idrules;

  @Column(name = "salary")
  private double salary;

  @Column(name = "is_debtor")
  private boolean is_debtor;

  @ManyToOne(targetEntity=Product.class, optional=false)
  @JoinColumn(name="idproduct")
  @JsonIgnore
  private Product product;

  public Rule(){

  }

  public Rule(Long identity, int idrules, double salary, boolean is_debtor, Product product) {
    this.identity = identity;
    this.idrules = idrules;
    this.salary = salary;
    this.is_debtor = is_debtor;
    this.product = product;
  }
}
