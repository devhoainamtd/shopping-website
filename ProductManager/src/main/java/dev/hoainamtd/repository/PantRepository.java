package dev.hoainamtd.repository;

import dev.hoainamtd.model.Pant;
import dev.hoainamtd.model.Shirt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantRepository extends JpaRepository<Pant, Long> {
    Pant findByName(String name);
    boolean existsByName(String name);

}
