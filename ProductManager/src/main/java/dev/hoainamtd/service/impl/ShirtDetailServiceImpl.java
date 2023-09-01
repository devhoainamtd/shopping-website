package dev.hoainamtd.service.impl;

import dev.hoainamtd.dto.ColorDTO;
import dev.hoainamtd.dto.ShirtDTO;
import dev.hoainamtd.dto.ShirtDetailDTO;
import dev.hoainamtd.dto.SizeDTO;
import dev.hoainamtd.model.Color;
import dev.hoainamtd.model.Shirt;
import dev.hoainamtd.model.ShirtDetail;
import dev.hoainamtd.model.Size;
import dev.hoainamtd.repository.ColorRepository;
import dev.hoainamtd.repository.ShirtDetailRepository;
import dev.hoainamtd.repository.ShirtRepository;
import dev.hoainamtd.repository.SizeRepository;
import dev.hoainamtd.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShirtDetailServiceImpl implements ProductDetailService<ShirtDetailDTO, ShirtDTO> {

    @Autowired
    private ShirtDetailRepository shirtDetailRepository;

    @Autowired
    private ShirtRepository shirtRepository;
    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;


    @Override
    public void saveEntity(ShirtDTO shirtDTO, long sizeId, long colorId, long quantity) {

        Shirt shirt = shirtRepository.findByName(mapToEntity(shirtDTO).getName());

        Size size = sizeRepository.findById(sizeId).get();

        Color color = colorRepository.findById(colorId).get();

        ShirtDetail shirtDetail = new ShirtDetail();

        shirtDetail.setShirt(shirt);
        shirtDetail.setSize(size);
        shirtDetail.setColor(color);
        shirtDetail.setQuantity(quantity);

        shirtDetailRepository.save(shirtDetail);

    }

    @Override
    public ShirtDetailDTO updateE(ShirtDetailDTO entity, ShirtDTO shirtDTO) {

        return null;
    }

    @Override
    public void delete(ShirtDetailDTO entity, ShirtDTO shirtDTO) {

    }

    @Override
    public List<ShirtDTO> getAllE() {
        return null;
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

        shirtDTO.setName(shirt.getName());
        shirtDTO.setPrice(shirt.getPrice());
        shirtDTO.setUrl(shirt.getUrl());
        shirtDTO.setMadeIn(shirt.getMadeIn());

        return shirtDTO;
    }

    private ShirtDetail mapToEntity(ShirtDetailDTO shirtDetailDTO, Shirt shirt, Size size, Color color) {
        ShirtDetail shirtDetail = new ShirtDetail();

        shirtDetail.setShirt(shirt);
        shirtDetail.setSize(size);
        shirtDetail.setColor(color);
        shirtDetail.setQuantity(shirtDetailDTO.getQuantity());

        return shirtDetail;
    }

    private ShirtDetailDTO mapToDTO(ShirtDetail shirtDetail, ShirtDTO shirtDTO, SizeDTO size, ColorDTO color) {
        ShirtDetailDTO shirtDetailDTO = new ShirtDetailDTO();

        shirtDetailDTO.setShirtDTO(shirtDTO);
        shirtDetailDTO.setSizeDTO(size);
        shirtDetailDTO.setColorDTO(color);
        shirtDetailDTO.setQuantity(shirtDetailDTO.getQuantity());

        return shirtDetailDTO;
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
