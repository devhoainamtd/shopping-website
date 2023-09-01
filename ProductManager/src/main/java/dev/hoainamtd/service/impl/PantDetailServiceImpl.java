package dev.hoainamtd.service.impl;

import dev.hoainamtd.dto.*;
import dev.hoainamtd.model.*;
import dev.hoainamtd.repository.ColorRepository;
import dev.hoainamtd.repository.PantDetailRepository;
import dev.hoainamtd.repository.PantRepository;
import dev.hoainamtd.repository.SizeRepository;
import dev.hoainamtd.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantDetailServiceImpl implements ProductDetailService<PantDetailDTO, PantDTO> {
    @Autowired
    private PantDetailRepository pantDetailRepository;
    @Autowired
    private PantRepository pantRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public void saveEntity(PantDTO pantDTO, long sizeId, long colorId, long quantity) {

        Pant pant = pantRepository.findByName(mapToEntity(pantDTO).getName());

        Size size = sizeRepository.findById(sizeId).get();

        Color color = colorRepository.findById(colorId).get();

        PantDetail pantDetail = new PantDetail();

        pantDetail.setPant(pant);
        pantDetail.setSize(size);
        pantDetail.setColor(color);
        pantDetail.setQuantity(quantity);

        pantDetailRepository.save(pantDetail);
    }

    @Override
    public PantDetailDTO updateE(PantDetailDTO entity, PantDTO pantDTO) {
        return null;
    }

    @Override
    public void delete(PantDetailDTO entity, PantDTO pantDTO) {

    }

    @Override
    public List<PantDTO> getAllE() {
        return null;
    }

//    map
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

        pantDTO.setName(pant.getName());
        pantDTO.setPrice(pant.getPrice());
        pantDTO.setUrl(pant.getUrl());
        pantDTO.setMadeIn(pant.getMadeIn());

        return pantDTO;
    }

    private PantDetail mapToEntity(PantDetailDTO pantDetailDTO, Pant pant, Size size, Color color) {
        PantDetail pantDetail = new PantDetail();

        pantDetail.setPant(pant);
        pantDetail.setSize(size);
        pantDetail.setColor(color);
        pantDetail.setQuantity(pantDetailDTO.getQuantity());

        return pantDetail;
    }

    private PantDetailDTO mapToDTO(PantDetail pantDetail, PantDTO pantDTO, SizeDTO size, ColorDTO color) {
        PantDetailDTO pantDetailDTO = new PantDetailDTO();

        pantDetailDTO.setPantDTO(pantDTO);
        pantDetailDTO.setSizeDTO(size);
        pantDetailDTO.setColorDTO(color);
        pantDetailDTO.setQuantity(pantDetail.getQuantity());

        return pantDetailDTO;
    }

    //    size
    private SizeDTO mapToDTO(Size size) {
        SizeDTO sizeDTO = new SizeDTO();

        sizeDTO.setId(size.getId());
        sizeDTO.setName(size.getName());

        return sizeDTO;
    }

    //    color
    private ColorDTO mapToDTO(Color color) {
        ColorDTO colorDTO = new ColorDTO();

        colorDTO.setId(color.getId());
        colorDTO.setName(color.getName());

        return colorDTO;
    }
}
