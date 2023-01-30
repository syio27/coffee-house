package pja.mas.coffeehouse;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pja.mas.coffeehouse.model.products.Beverage;
import pja.mas.coffeehouse.model.products.BeverageType;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.model.products.CoffeeType;
import pja.mas.coffeehouse.model.users.Customer;
import pja.mas.coffeehouse.model.enums.*;
import pja.mas.coffeehouse.repository.*;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final CoffeeRepository coffeeRepository;
    private final BeverageRepository beverageRepository;
    private final CoffeeTypeRepository coffeeTypeRepository;
    private final BeverageTypeRepository beverageTypeRepository;

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

        //CoffeeType in-memory data load to db
        CoffeeType coffeeType1 = CoffeeType.builder()
                .name("Latte")
                .build();
        CoffeeType coffeeType2 = CoffeeType.builder()
                .name("Americano")
                .build();
        CoffeeType coffeeType3 = CoffeeType.builder()
                .name("Iced latte")
                .build();
        CoffeeType coffeeType4 = CoffeeType.builder()
                .name("Java Frappuccino")
                .build();
        CoffeeType coffeeType5 = CoffeeType.builder()
                .name("Espresso")
                .build();

        coffeeTypeRepository.saveAll(List.of(coffeeType1, coffeeType2, coffeeType3, coffeeType4, coffeeType5));

        //Coffee in-memory data load to DB
        Coffee coffee1 = Coffee.builder()
                .price(9.99D)
                .size(Size.LARGE)
                .onStock(true)
                .sugarType(SugarType.NO)
                .milkType(MilkType.REGULAR)
                .coffeeType(coffeeType1)
                .build();
        Coffee coffee2 = Coffee.builder()
                .price(12.99D)
                .size(Size.MEDIUM)
                .onStock(true)
                .sugarType(SugarType.NO)
                .milkType(MilkType.REGULAR)
                .coffeeType(coffeeType2)
                .build();
        Coffee coffee3 = Coffee.builder()
                .price(5.99D)
                .size(Size.SMALL)
                .onStock(true)
                .sugarType(SugarType.NO)
                .milkType(MilkType.REGULAR)
                .coffeeType(coffeeType3)
                .build();
        Coffee coffee4 = Coffee.builder()
                .price(18.99D)
                .size(Size.LARGE)
                .onStock(true)
                .sugarType(SugarType.NO)
                .milkType(MilkType.REGULAR)
                .coffeeType(coffeeType4)
                .build();
        Coffee coffee5 = Coffee.builder()
                .price(3.99D)
                .size(Size.SMALL)
                .onStock(true)
                .sugarType(SugarType.NO)
                .milkType(MilkType.REGULAR)
                .coffeeType(coffeeType5)
                .build();

        coffeeRepository.saveAll(List.of(coffee1, coffee2, coffee3, coffee4, coffee5));

        //CoffeeType in-memory data load to db
        BeverageType beverageType1 = BeverageType.builder()
                .name("Freshly Squeezed Lemonade")
                .build();
        BeverageType beverageType2 = BeverageType.builder()
                .name("Brazilian Lemonade")
                .build();
        BeverageType beverageType3 = BeverageType.builder()
                .name("Raspberry Lemonade")
                .build();
        BeverageType beverageType4 = BeverageType.builder()
                .name("Sparkling Blackberry Lemonade")
                .build();
        BeverageType beverageType5 = BeverageType.builder()
                .name("Mango Lemonade")
                .build();

        beverageTypeRepository.saveAll(List.of(beverageType1, beverageType2, beverageType3, beverageType4, beverageType5));

        //Beverage in-memory data load to DB
        Beverage beverage1 = Beverage.builder()
                .price(3.99D)
                .size(Size.SMALL)
                .onStock(true)
                .ice(true)
                .beverageType(beverageType1)
                .build();
        Beverage beverage2 = Beverage.builder()
                .price(1.99D)
                .size(Size.SMALL)
                .onStock(true)
                .ice(true)
                .beverageType(beverageType2)
                .build();
        Beverage beverage3 = Beverage.builder()
                .price(10.99D)
                .size(Size.LARGE)
                .onStock(true)
                .ice(true)
                .beverageType(beverageType3)
                .build();
        Beverage beverage4 = Beverage.builder()
                .price(10.99D)
                .size(Size.LARGE)
                .onStock(true)
                .ice(true)
                .beverageType(beverageType4)
                .build();
        Beverage beverage5 = Beverage.builder()
                .price(3.99D)
                .size(Size.SMALL)
                .onStock(true)
                .ice(true)
                .beverageType(beverageType5)
                .build();

        beverageRepository.saveAll(List.of(beverage1, beverage2, beverage3, beverage4, beverage5));

        //
    }
}
