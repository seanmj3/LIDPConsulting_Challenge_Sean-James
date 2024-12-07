package com.lidp.challenge.se2.persistence.entity;

import jakarta.persistence.*;

// Address table with street, zipcode, state, country and city columns. Relationship with customer entity is Many-to-One.
@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int address_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipcode;
    @Column
    private String country;

    public int getAddress_id() { return address_id; }

    public void setAddress_id( int address_id ) { this.address_id = address_id; }

    public CustomerEntity getCustomer() { return customer; }

    public void setCustomer(CustomerEntity customer) { this.customer = customer; }

    public String getStreet() { return street; }

    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getZipcode() { return zipcode; }

    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }
}