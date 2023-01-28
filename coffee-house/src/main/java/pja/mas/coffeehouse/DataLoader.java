package pja.mas.coffeehouse;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pja.mas.coffeehouse.model.products.Beverage;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.model.users.Customer;
import pja.mas.coffeehouse.model.enums.*;
import pja.mas.coffeehouse.repository.BeverageRepository;
import pja.mas.coffeehouse.repository.CoffeeRepository;
import pja.mas.coffeehouse.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CoffeeRepository coffeeRepository;
    private final BeverageRepository beverageRepository;

    @Override
    public void run(String... args) throws Exception {
        //Customer in-memory data load to DB
        Customer customer1 = Customer.builder()
                .firstName("customer1")
                .lastName("customer1")
                .birthDate(LocalDate.now())
                .age(1)
                .sex(Sex.FEMALE)
                .address("address")
                .wallet(1200D)
                .paymentMethod(PaymentMethod.CARD)
                .build();
        Customer customer2 = Customer.builder()
                .firstName("customer2")
                .lastName("customer2")
                .birthDate(LocalDate.now())
                .age(1)
                .sex(Sex.FEMALE)
                .address("address")
                .wallet(1200D)
                .paymentMethod(PaymentMethod.BONUSES)
                .build();
        Customer customer3 = Customer.builder()
                .firstName("customer3")
                .lastName("customer3")
                .birthDate(LocalDate.now())
                .age(1)
                .sex(Sex.MALE)
                .address("address")
                .wallet(1200D)
                .paymentMethod(PaymentMethod.CARD)
                .build();
        Customer customer4 = Customer.builder()
                .firstName("customer4")
                .lastName("customer4")
                .birthDate(LocalDate.now())
                .age(1)
                .sex(Sex.MALE)
                .address("address")
                .wallet(1200D)
                .paymentMethod(PaymentMethod.CASH)
                .build();

        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4));

        //Coffee in-memory data load to DB
        Coffee coffee1 = Coffee.builder()
                .price(9.99D)
                .size(Size.LARGE)
                .onStock(true)
                .sugarType(SugarType.WHITE)
                .milkType(MilkType.REGULAR)
                .build();
        Coffee coffee2 = Coffee.builder()
                .price(12.99D)
                .size(Size.MEDIUM)
                .onStock(true)
                .sugarType(SugarType.CANE)
                .milkType(MilkType.REGULAR)
                .build();
        Coffee coffee3 = Coffee.builder()
                .price(5.99D)
                .size(Size.SMALL)
                .onStock(true)
                .sugarType(SugarType.BROWN)
                .milkType(MilkType.NO)
                .build();
        Coffee coffee4 = Coffee.builder()
                .price(18.99D)
                .size(Size.LARGE)
                .onStock(true)
                .sugarType(SugarType.CASTER)
                .milkType(MilkType.REGULAR)
                .build();
        Coffee coffee5 = Coffee.builder()
                .price(3.99D)
                .size(Size.SMALL)
                .onStock(true)
                .sugarType(SugarType.WHITE)
                .milkType(MilkType.SOYMILK)
                .build();

        coffeeRepository.saveAll(List.of(coffee1, coffee2, coffee3, coffee4, coffee5));

        //Beverage in-memory data load to DB
        Beverage beverage1 = Beverage.builder()
                .price(3.99D)
                .size(Size.SMALL)
                .onStock(true)
                .ice(true)
                .build();
        Beverage beverage2 = Beverage.builder()
                .price(1.99D)
                .size(Size.SMALL)
                .onStock(true)
                .ice(true)
                .build();
        Beverage beverage3 = Beverage.builder()
                .price(10.99D)
                .size(Size.LARGE)
                .onStock(true)
                .ice(true)
                .build();
        Beverage beverage4 = Beverage.builder()
                .price(10.99D)
                .size(Size.LARGE)
                .onStock(true)
                .ice(true)
                .build();
        Beverage beverage5 = Beverage.builder()
                .price(3.99D)
                .size(Size.SMALL)
                .onStock(true)
                .ice(true)
                .build();

        beverageRepository.saveAll(List.of(beverage1, beverage2, beverage3, beverage4, beverage5));

        //
    }
}
