package dev.hoainamtd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {

    private Long sizeId;

    private Long colorId;

    private Long quantity;

}
