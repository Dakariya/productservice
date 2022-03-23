package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "identity")
  @JsonIgnore
  private int identity;

  @Column(name = "idproduct")
  private int idproduct;

  @Column(name = "claim")
  private double claim;

  @Column(name = "roi")
  private int roi;

  @Column(name = "years")
  private int years;

  public Product(){

  }

  public Product(int identity, int idproduct, double claim, int roi, int years) {
    this.identity = identity;
    this.idproduct = idproduct;
    this.claim = claim;
    this.roi = roi;
    this.years = years;
  }
}
