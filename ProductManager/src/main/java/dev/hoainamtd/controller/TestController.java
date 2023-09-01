package dev.hoainamtd.controller;

import dev.hoainamtd.dto.ProductDetail;
import dev.hoainamtd.dto.RequestShirt;
import dev.hoainamtd.dto.ShirtDTO;
import dev.hoainamtd.service.impl.ShirtDetailServiceImpl;
import dev.hoainamtd.service.impl.ShirtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/")
public class TestController {

    @Autowired
    private ShirtDetailServiceImpl shirtDetailService;
    @Autowired
    private ShirtServiceImpl shirtService;

    @PostMapping("save")
    public ResponseEntity<?> saveShirt(@org.springframework.web.bind.annotation.RequestBody RequestShirt requestBody) {

        if (shirtService.checkName(requestBody.getShirtDTO().getName())) {
            ShirtDTO shirtDTO = shirtService.saveE(requestBody.getShirtDTO());

            for (ProductDetail detail : requestBody.getList()) {
                shirtDetailService.saveEntity(
                        shirtDTO,
                        detail.getSizeId(),
                        detail.getColorId(),
                        detail.getQuantity()
                );
            }

            return new ResponseEntity<>("", HttpStatus.OK);

        } else {

            return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);

        }
    }
}
