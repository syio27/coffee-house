package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.model.products.Topping;

import java.util.List;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
    @Query("SELECT t FROM Topping t LEFT JOIN t.toppingType tt WHERE tt.id = t.toppingType.id")
    List<Topping> findToppingsWithTypes();

    //SELECT * FROM TOPPING t LEFT JOIN Topping_Type tt ON t.topping_type_id = tt.id WHERE t.id = 16;
    @Query("SELECT t FROM Topping t LEFT JOIN t.toppingType tt ON tt.id = t.toppingType.id WHERE t.id = :id")
    Topping findToppingByIdWithType(@Param("id") Long id);

//    @Query("SELECT t FROM Topping t WHERE t.coffee.id = :id")
    @Query(value = "SELECT * FROM Topping t WHERE t.coffee_id = ?1", nativeQuery = true)
    List<Topping> findToppingByCoffeeId(Long id);

    //SELECT * FROM Topping t JOIN Coffee c ON t.coffee_id = c.id WHERE c.id = 12;
}
