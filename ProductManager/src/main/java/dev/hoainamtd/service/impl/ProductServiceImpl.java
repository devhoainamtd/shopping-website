package dev.hoainamtd.service.impl;

import dev.hoainamtd.dto.ProductDTO;
import dev.hoainamtd.model.Product;
import dev.hoainamtd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements dev.hoainamtd.service.ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductDTO> listAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToDTO(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public ProductDTO findProductById(Long id) {
        Product product = productRepository.findById(id).get();
        return mapToDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).get();
        product.setProductName(productDTO.getProductName());
        product.setBrand(productDTO.getBrand());
        product.setMadeIn(productDTO.getMadeIn());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    //map
    private Product mapToEntity(ProductDTO productDTO) {

        Product product = new Product();

        product.setProductName(productDTO.getProductName());
        product.setBrand(productDTO.getBrand());
        product.setPrice(productDTO.getPrice());
        product.setMadeIn(productDTO.getMadeIn());

        return product;
    }

    private ProductDTO mapToDTO(Product product) {

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setBrand(product.getBrand());
        productDTO.setPrice(product.getPrice());
        productDTO.setMadeIn(product.getMadeIn());

        return productDTO;
    }
}
