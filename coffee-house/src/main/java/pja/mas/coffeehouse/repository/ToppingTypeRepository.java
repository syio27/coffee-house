package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pja.mas.coffeehouse.model.products.ToppingType;

public interface ToppingTypeRepository extends JpaRepository<ToppingType, Long> {
}
