package pja.mas.coffeehouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pja.mas.coffeehouse.dto.CustomerRequest;
import pja.mas.coffeehouse.dto.CustomerResponse;
import pja.mas.coffeehouse.exception.CustomerNotFoundException;
import pja.mas.coffeehouse.model.users.Customer;
import pja.mas.coffeehouse.repository.CustomerRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

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
    public CustomerResponse getCustomerById(Long id) {
        log.info("User are retrieved {} ", id);
        return customerRepository.findById(id)
                .map(this::mapToCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void save(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .birthDate(customerRequest.getBirthDate())
                .age(calculateAge(customerRequest.getBirthDate()))
                .sex(customerRequest.getSex())
                .address(customerRequest.getAddress())
                .wallet(0D)
                .paymentMethod(customerRequest.getPaymentMethod())
                .build();

        log.info("Customer {}'s info is saved ", customer.getId());
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        customerRepository.deleteById(id);
    }

    @Override
    public void update(Long id, CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .id(id)
                .firstName(customerRequest.getFirstName())
                .lastName(customerRequest.getLastName())
                .birthDate(customerRequest.getBirthDate())
                .age(calculateAge(customerRequest.getBirthDate()))
                .sex(customerRequest.getSex())
                .address(customerRequest.getAddress())
                .wallet(currentWallet(id))
                .paymentMethod(customerRequest.getPaymentMethod())
                .build();

        customerRepository.save(customer);
    }

    private Double currentWallet(Long id){
        Customer customer = findById(id);
        return customer.getWallet();
    }

    private Customer findById(Long id){
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    private int calculateAge(LocalDate birthDate){
        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(birthDate, currentDate);
        return age.getYears();
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
