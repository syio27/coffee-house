package pja.mas.coffeehouse;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pja.mas.coffeehouse.model.Customer;
import pja.mas.coffeehouse.model.enums.PaymentMethod;
import pja.mas.coffeehouse.model.enums.Sex;
import pja.mas.coffeehouse.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
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
    }
}
