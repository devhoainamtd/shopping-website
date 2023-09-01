package dev.hoainamtd.service;

import dev.hoainamtd.dto.ProductDTO;

import java.util.List;

public interface ProductService<E extends ProductDTO> {
    E saveE(E e);
    E update(E e);
    void delete(E e);
    List<E> showListE();

    boolean checkName(String name);
}
