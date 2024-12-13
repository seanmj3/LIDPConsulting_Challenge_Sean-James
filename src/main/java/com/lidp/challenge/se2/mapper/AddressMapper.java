package com.lidp.challenge.se2.mapper;

import com.lidp.challenge.se2.domain.AddressDTO;
import com.lidp.challenge.se2.persistence.entity.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDTO toDTO(AddressEntity entity) {
        AddressDTO dto = new AddressDTO();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipcode(entity.getZipcode());
        dto.setCountry(entity.getCountry());
        return dto;
    }

    public AddressEntity toEntity(AddressDTO dto) {
        AddressEntity entity = new AddressEntity();
        entity.setId(dto.getId());
        entity.setStreet(dto.getStreet());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZipcode(dto.getZipcode());
        entity.setCountry(dto.getCountry());
        return entity;
    }
}
