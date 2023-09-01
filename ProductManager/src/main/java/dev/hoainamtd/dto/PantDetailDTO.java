package dev.hoainamtd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PantDetailDTO {

    private Long id;

    private PantDTO pantDTO;

    private ColorDTO colorDTO;

    private SizeDTO sizeDTO;

    private Long quantity;

}
