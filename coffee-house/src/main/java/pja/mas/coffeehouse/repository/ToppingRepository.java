package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.model.products.Topping;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
    @Query("SELECT t FROM Topping t LEFT JOIN t.toppingType tt WHERE tt.id = t.toppingType.id")
    List<Topping> findToppingsWithTypes();
}
