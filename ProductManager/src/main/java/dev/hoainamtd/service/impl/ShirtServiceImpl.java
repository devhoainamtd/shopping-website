package dev.hoainamtd.service.impl;

import dev.hoainamtd.dto.ShirtDTO;
import dev.hoainamtd.model.Shirt;
import dev.hoainamtd.repository.ShirtRepository;
import dev.hoainamtd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShirtServiceImpl implements ProductService<ShirtDTO> {
    @Autowired
    private ShirtRepository shirtRepository;

    @Override
    public ShirtDTO saveE(ShirtDTO shirtDTO) {
        Shirt shirt = mapToEntity(shirtDTO);
        shirtRepository.save(shirt);
        return mapToDTO(shirt);
    }

    @Override
    public ShirtDTO update(ShirtDTO shirtDTO) {
        return null;
    }

    @Override
    public void delete(ShirtDTO shirtDTO) {

    }

    @Override
    public List<ShirtDTO> showListE() {
        List<Shirt> dtoList =shirtRepository.findAll();
        return dtoList.stream().map(shirt -> mapToDTO(shirt)).collect(Collectors.toList());
    }

    @Override
    public boolean checkName(String name) {
        if (!shirtRepository.existsByName(name)) {
            return true;
        } else {
            return false;
        }
    }

    private Shirt mapToEntity(ShirtDTO shirtDTO) {
        Shirt shirt = new Shirt();

        shirt.setName(shirtDTO.getName());
        shirt.setPrice(shirtDTO.getPrice());
        shirt.setUrl(shirtDTO.getUrl());
        shirt.setMadeIn(shirtDTO.getMadeIn());

        return shirt;
    }

    private ShirtDTO mapToDTO(Shirt shirt) {
        ShirtDTO shirtDTO = new ShirtDTO();

        shirtDTO.setId(shirt.getId());
        shirtDTO.setName(shirt.getName());
        shirtDTO.setPrice(shirt.getPrice());
        shirtDTO.setUrl(shirt.getUrl());
        shirtDTO.setMadeIn(shirt.getMadeIn());

        return shirtDTO;
    }
}
