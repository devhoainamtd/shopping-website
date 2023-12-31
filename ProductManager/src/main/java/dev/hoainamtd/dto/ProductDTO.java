package dev.hoainamtd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ProductDTO {

    private  Long id;

    private String name;

    private String madeIn;

    private String url;

    private float price;

}
