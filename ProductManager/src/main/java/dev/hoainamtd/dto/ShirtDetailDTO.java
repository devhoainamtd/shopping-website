package dev.hoainamtd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShirtDetailDTO {

    private Long id;

    private ShirtDTO shirtDTO;

    private ColorDTO colorDTO;

    private SizeDTO sizeDTO;

    private Long quantity;

}
