package com.lidp.challenge.se2.domain;

import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import jakarta.persistence.*;

public class AddressDTO {
    private Integer address_id;

    private CustomerEntity customer;


    private String street;

    private String city;

    private String state;

    private String zipcode;

    private String country;

    public void setId(Integer id) { this.address_id = id; }

    public Integer getId() { return address_id; }

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
