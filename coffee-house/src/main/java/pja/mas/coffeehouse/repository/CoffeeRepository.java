package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pja.mas.coffeehouse.model.products.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
