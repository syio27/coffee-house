package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pja.mas.coffeehouse.model.products.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    @Query("SELECT c FROM Coffee c LEFT JOIN c.coffeeType ct WHERE ct.id = c.coffeeType.id")
    List<Coffee> findCoffeesWithTypes();
}
