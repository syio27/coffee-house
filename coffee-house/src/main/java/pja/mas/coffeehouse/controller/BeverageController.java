package pja.mas.coffeehouse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageAndTypeResponse;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageRequest;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageResponse;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageUpdateRequest;
import pja.mas.coffeehouse.dto.coffeerelated.CoffeeAndTypeResponse;
import pja.mas.coffeehouse.dto.coffeerelated.CoffeeRequest;
import pja.mas.coffeehouse.dto.coffeerelated.CoffeeResponse;
import pja.mas.coffeehouse.dto.coffeerelated.CoffeeUpdateRequest;
import pja.mas.coffeehouse.service.BeverageService;

import java.util.List;

@RestController
@RequestMapping("/api/beverages")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class BeverageController {

    private final BeverageService beverageService;

    @PostMapping()
    public ResponseEntity<?> saveBeverage(@RequestBody BeverageRequest beverageRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        beverageService.save(beverageRequest);
        return new ResponseEntity<>(beverageRequest, HttpStatus.CREATED);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<BeverageResponse> getListOfBeverages(){
        return beverageService.getBeverages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeverageResponse> getBeverageById(@PathVariable Long id){
        BeverageResponse beverageResponse = beverageService.getBeverageById(id);
        return ResponseEntity.ok(beverageResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBeverageDetailsById(@PathVariable Long id,
                                                     @RequestBody BeverageUpdateRequest beverageUpdateRequest,
                                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        beverageService.update(id, beverageUpdateRequest);
        log.info("Beverage {}'s details is updated {}", id, beverageUpdateRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/types")
    @ResponseStatus(HttpStatus.OK)
    public List<BeverageAndTypeResponse> getListOfBeveragesWithTypes(){
        return beverageService.getBeveragesWithTypes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeverageById(@PathVariable Long id){
        beverageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
