package dev.hoainamtd.repository;

import dev.hoainamtd.model.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShirtRepository extends JpaRepository<Shirt, Long> {
    Shirt findByName(String name);
    boolean existsByName(String name);

}
