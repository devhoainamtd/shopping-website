package dev.hoainamtd.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestShirt {

    private ShirtDTO shirtDTO;

    List<ProductDetail> list;

}
