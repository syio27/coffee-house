package pja.mas.coffeehouse.service;

import pja.mas.coffeehouse.dto.customerrelated.CustomerRequest;
import pja.mas.coffeehouse.dto.customerrelated.CustomerResponse;

import java.util.List;

public interface CustomerService {
    public List<CustomerResponse> getCustomers();
    public CustomerResponse getCustomerById(Long id);
    public void save(CustomerRequest customerRequest);
    public void delete(Long id);
    public void update(Long id, CustomerRequest customerRequest);
}
