package pja.mas.coffeehouse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pja.mas.coffeehouse.dto.customerrelated.CustomerRequest;
import pja.mas.coffeehouse.dto.customerrelated.CustomerResponse;
import pja.mas.coffeehouse.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping()
    public ResponseEntity<?> register(@RequestBody CustomerRequest customerRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        customerService.save(customerRequest);
        return new ResponseEntity<>(customerRequest, HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponse> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id){
        CustomerResponse customerResponse = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomerById(@PathVariable Long id,
                                            @RequestBody CustomerRequest customerRequest,
                                            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        customerService.update(id, customerRequest);
        log.info("Customer {} is updated {}", id, customerRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
