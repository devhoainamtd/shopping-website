package dev.hoainamtd.service;

import java.util.List;

public interface ProductDetailService<E, T> {

    void saveEntity(T t, long sizeId, long colorId, long quantity);
    E updateE(E entity, T t);
    void delete(E entity, T t);
    List<T> getAllE();
}
