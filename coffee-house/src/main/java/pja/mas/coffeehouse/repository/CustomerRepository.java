package pja.mas.coffeehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pja.mas.coffeehouse.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
