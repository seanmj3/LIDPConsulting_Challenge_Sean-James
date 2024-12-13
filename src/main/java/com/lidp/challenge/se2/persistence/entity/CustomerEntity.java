package com.lidp.challenge.se2.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

// Customer table with an id and name as columns. Relationship with address is One-to-Many.
@Entity
@Table(name = "customer")
public class CustomerEntity {
  // Primary Key
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;

  @Column
  private String name;

  public CustomerEntity(Integer id, String name, List<AddressEntity> addresses) {
    this.id = id;
    this.name = name;
    this.addresses = addresses;
  }

  public CustomerEntity() {}

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AddressEntity> addresses;

  public int getId() { return id; }

  public void setId(int id) { this.id = id; }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AddressEntity> getAddresses() { return addresses; }

  public void setAddresses(List<AddressEntity> addresses) { this.addresses = addresses; }
}
