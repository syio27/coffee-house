package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pja.mas.coffeehouse.model.products.Coffee;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    @Query("SELECT c FROM Coffee c LEFT JOIN c.coffeeType ct WHERE ct.id = c.coffeeType.id")
    List<Coffee> findCoffeesWithTypes();

    //SELECT * FROM Coffee c LEFT JOIN Coffee_Type ct ON ct.id = c.coffee_type_id WHERE c.id = 11;
    @Query("SELECT c FROM Coffee c LEFT JOIN c.coffeeType ct ON ct.id = c.coffeeType.id WHERE c.id = :id")
    Coffee findCoffeeByIdWithType(@Param("id") Long id);
}
