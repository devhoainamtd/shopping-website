package dev.hoainamtd.dto;

import lombok.Data;

import java.util.List;

@Data
public class RequestPant {

    private PantDTO pantDTO;

    List<ProductDetail> list;

}
