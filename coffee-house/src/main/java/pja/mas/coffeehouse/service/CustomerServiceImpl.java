package pja.mas.coffeehouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pja.mas.coffeehouse.dto.CustomerRequest;
import pja.mas.coffeehouse.dto.CustomerResponse;
import pja.mas.coffeehouse.model.Customer;
import pja.mas.coffeehouse.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerResponse> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        log.info("Customers are retrieved {} ", customers);
        return customers.stream().map(this::mapToCustomerResponse).toList();
    }

    @Override
    public Optional<CustomerResponse> getCustomer() {
        return Optional.empty();
    }

    @Override
    public void save(CustomerRequest customerRequest) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, CustomerRequest customerRequest) {

    }

    private CustomerResponse mapToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .birthDate(customer.getBirthDate())
                .age(customer.getAge())
                .sex(customer.getSex())
                .address(customer.getAddress())
                .wallet(customer.getWallet())
                .paymentMethod(customer.getPaymentMethod())
                .build();
    }
}
