package pja.mas.coffeehouse.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pja.mas.coffeehouse.dto.coffeerelated.ToppingResponse;
import pja.mas.coffeehouse.service.ToppingService;

import java.util.List;

@RestController
@RequestMapping("/api/toppings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class ToppingController {

    private final ToppingService toppingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ToppingResponse> getToppingsWithTypes(){
        return toppingService.getToppingsWithTypes();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ToppingResponse getToppingWithType(@PathVariable Long id){
        return toppingService.getToppingByIdWithType(id);
    }
}
