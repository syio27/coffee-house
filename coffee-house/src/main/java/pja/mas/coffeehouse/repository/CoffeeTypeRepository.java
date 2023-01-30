package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pja.mas.coffeehouse.model.products.CoffeeType;

public interface CoffeeTypeRepository extends JpaRepository<CoffeeType, Long> {
}
