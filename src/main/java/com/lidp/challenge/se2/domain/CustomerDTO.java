package com.lidp.challenge.se2.domain;

import com.lidp.challenge.se2.persistence.entity.AddressEntity;

import java.util.List;

public class CustomerDTO {
    private Integer id;
    private String name;

    private List<AddressDTO> addresses;

    public CustomerDTO(Integer id, String name, List<AddressDTO> addresses) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
    }

    public CustomerDTO() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressDTO> getAddresses() { return addresses; }

    public void setAddresses(List<AddressDTO> addresses) { this.addresses = addresses; }

}

