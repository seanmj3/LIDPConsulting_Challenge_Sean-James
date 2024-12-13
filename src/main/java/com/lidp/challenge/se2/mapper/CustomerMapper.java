package com.lidp.challenge.se2.mapper;

import com.lidp.challenge.se2.domain.CustomerDTO;
import com.lidp.challenge.se2.domain.AddressDTO;
import com.lidp.challenge.se2.persistence.entity.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    private final AddressMapper addressMapper;

    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDTO toDTO(CustomerEntity entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddresses(
                entity.getAddresses().stream()
                        .map(addressMapper::toDTO)
                        .collect(Collectors.toList()).reversed()
        );
        return dto;
    }

    public CustomerEntity toEntity(CustomerDTO dto) {
        CustomerEntity entity = new CustomerEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddresses(
                dto.getAddresses().stream()
                        .map(addressMapper::toEntity)
                        .collect(Collectors.toList())
        );
        return entity;
    }
}
