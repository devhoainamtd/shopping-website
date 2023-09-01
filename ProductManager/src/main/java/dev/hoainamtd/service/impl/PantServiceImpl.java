package dev.hoainamtd.service.impl;

import dev.hoainamtd.dto.PantDTO;
import dev.hoainamtd.model.Pant;
import dev.hoainamtd.repository.PantRepository;
import dev.hoainamtd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PantServiceImpl implements ProductService<PantDTO> {

    @Autowired
    private PantRepository pantRepository;

    @Override
    public PantDTO saveE(PantDTO pantDTO) {
        Pant pant = mapToEntity(pantDTO);
        pantRepository.save(pant);
        return mapToDTO(pant);
    }

    @Override
    public PantDTO update(PantDTO pantDTO) {
        return null;
    }

    @Override
    public void delete(PantDTO pantDTO) {

    }
    @Override
    public List<PantDTO> showListE() {
        List<Pant> dtoList = pantRepository.findAll();
        return dtoList.stream().map(pant -> mapToDTO(pant)).collect(Collectors.toList());
    }
    @Override
    public boolean checkName(String name) {
        if (!pantRepository.existsByName(name)) {
            return true;
        } else {
            return false;
        }
    }

    private Pant mapToEntity(PantDTO pantDTO) {
        Pant pant = new Pant();

        pant.setName(pantDTO.getName());
        pant.setPrice(pantDTO.getPrice());
        pant.setUrl(pantDTO.getUrl());
        pant.setMadeIn(pantDTO.getMadeIn());

        return pant;
    }

    private PantDTO mapToDTO(Pant pant) {
        PantDTO pantDTO = new PantDTO();

        pantDTO.setId(pant.getId());
        pantDTO.setName(pant.getName());
        pantDTO.setPrice(pant.getPrice());
        pantDTO.setUrl(pant.getUrl());
        pantDTO.setMadeIn(pant.getMadeIn());

        return pantDTO;
    }
}
