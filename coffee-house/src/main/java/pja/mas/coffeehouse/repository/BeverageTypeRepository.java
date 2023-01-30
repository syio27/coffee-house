package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pja.mas.coffeehouse.model.products.BeverageType;

public interface BeverageTypeRepository extends JpaRepository<BeverageType, Long> {
}
