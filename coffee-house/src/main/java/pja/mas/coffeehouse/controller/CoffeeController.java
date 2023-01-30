package pja.mas.coffeehouse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pja.mas.coffeehouse.dto.CoffeeAndTypeResponse;
import pja.mas.coffeehouse.dto.CoffeeRequest;
import pja.mas.coffeehouse.dto.CoffeeResponse;
import pja.mas.coffeehouse.dto.CoffeeUpdateRequest;
import pja.mas.coffeehouse.service.CoffeeService;
import java.util.List;

@RestController
@RequestMapping("/api/coffees")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class CoffeeController {
    private final CoffeeService coffeeService;

    @PostMapping()
    public ResponseEntity<?> saveCoffee(@RequestBody CoffeeRequest coffeeRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        coffeeService.save(coffeeRequest);
        return new ResponseEntity<>(coffeeRequest, HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CoffeeResponse> getListOfCoffees(){
        return coffeeService.getCoffees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeResponse> getCoffeeById(@PathVariable Long id){
        CoffeeResponse coffeeResponse = coffeeService.getCoffeeById(id);
        return ResponseEntity.ok(coffeeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoffeeDetailsById(@PathVariable Long id,
                                                @RequestBody CoffeeUpdateRequest coffeeUpdateRequest,
                                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        coffeeService.update(id, coffeeUpdateRequest);
        log.info("Coffee {}'s details is updated {}", id, coffeeUpdateRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    public List<CoffeeAndTypeResponse> getListOfCoffeesWithTypes(){
        return coffeeService.getCoffeesWithTypes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffeeById(@PathVariable Long id){
        coffeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
