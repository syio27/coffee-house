package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pja.mas.coffeehouse.model.products.Beverage;
import pja.mas.coffeehouse.model.products.Coffee;

import java.util.List;

public interface BeverageRepository extends JpaRepository<Beverage, Long> {
    @Query("SELECT b FROM Beverage b LEFT JOIN b.beverageType bt WHERE bt.id = b.beverageType.id")
    List<Beverage> findBeverageAndType();
}
