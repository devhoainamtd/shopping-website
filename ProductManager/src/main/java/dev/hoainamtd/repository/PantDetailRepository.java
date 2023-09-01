package dev.hoainamtd.repository;

import dev.hoainamtd.model.PantDetail;
import dev.hoainamtd.model.ShirtDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantDetailRepository extends JpaRepository<PantDetail, Long> {
}
