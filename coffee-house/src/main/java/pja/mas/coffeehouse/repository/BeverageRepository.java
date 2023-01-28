package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pja.mas.coffeehouse.model.products.Beverage;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
}
