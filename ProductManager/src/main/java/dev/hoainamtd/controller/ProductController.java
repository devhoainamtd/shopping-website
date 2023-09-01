package dev.hoainamtd.controller;

import dev.hoainamtd.dto.*;
import dev.hoainamtd.service.impl.PantDetailServiceImpl;
import dev.hoainamtd.service.impl.PantServiceImpl;
import dev.hoainamtd.service.impl.ShirtDetailServiceImpl;
import dev.hoainamtd.service.impl.ShirtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ShirtDetailServiceImpl shirtDetailService;
    @Autowired
    private PantDetailServiceImpl pantDetailService;
    @Autowired
    private ShirtServiceImpl shirtService;
    @Autowired
    private PantServiceImpl pantService;

    @GetMapping()
    public String listProducts() {
        return "index";
    }

    @GetMapping("/administration")
    public String administration(Model model) {

        List<ShirtDTO> listShirts = shirtService.showListE();
        List<PantDTO> listPants = pantService.showListE();

        model.addAttribute("listShirts", listShirts);
        model.addAttribute("listPants", listPants);

        return "administration";
    }

    @PostMapping("/save/shirt")
    public ResponseEntity<?> saveShirt(@org.springframework.web.bind.annotation.RequestBody RequestShirt requestBody) {

        if (shirtService.checkName(requestBody.getShirtDTO().getName())) {
            ShirtDTO shirtDTO = shirtService.saveE(requestBody.getShirtDTO());

            List<ProductDetail> list = requestBody.getList();

            for (ProductDetail detail : list) {
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

    @PostMapping("/save/pant")
    public ResponseEntity<?> savePant(@org.springframework.web.bind.annotation.RequestBody RequestPant requestBody) {

        if (pantService.checkName(requestBody.getPantDTO().getName())) {
            PantDTO pantDTO = pantService.saveE(requestBody.getPantDTO());

            for (ProductDetail detail : requestBody.getList()) {
                pantDetailService.saveEntity(
                        pantDTO,
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
