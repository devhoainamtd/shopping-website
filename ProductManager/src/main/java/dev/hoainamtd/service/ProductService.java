package dev.hoainamtd.service;

import dev.hoainamtd.dto.ProductDTO;
import dev.hoainamtd.model.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> listAll();
    ProductDTO saveProduct(ProductDTO productDTO);
    ProductDTO findProductById(Long id);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void delete(Long id);
}
