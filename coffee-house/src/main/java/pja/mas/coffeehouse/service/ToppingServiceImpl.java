package pja.mas.coffeehouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pja.mas.coffeehouse.dto.coffeerelated.CoffeeResponse;
import pja.mas.coffeehouse.dto.coffeerelated.ToppingResponse;
import pja.mas.coffeehouse.exception.ProductNotFoundException;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.model.products.Topping;
import pja.mas.coffeehouse.repository.ToppingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToppingServiceImpl implements ToppingService{

    private final ToppingRepository toppingRepository;

    @Override
    public List<ToppingResponse> getToppingsWithTypes() {
        List<Topping> toppings = toppingRepository.findToppingsWithTypes();
        return toppings.stream().map(this::mapToToppingResponse).toList();
    }

    @Override
    public ToppingResponse getToppingByIdWithType(Long id) {
        findById(id);
        Topping topping = toppingRepository.findToppingByIdWithType(id);
        return mapToToppingResponse(topping);
    }

    @Override
    public List<ToppingResponse> getToppingsByCoffeeId(Long id) {
        List<Topping> rawToppings = toppingRepository.findToppingByCoffeeId(id);
        List<ToppingResponse> toppingResponsesList = new ArrayList<>();
        for(Topping topping : rawToppings){
            ToppingResponse toppingResponse = getToppingByIdWithType(topping.getId());
            toppingResponsesList.add(toppingResponse);
        }
        return toppingResponsesList;
    }


    private Topping findById(Long id){
        return toppingRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private ToppingResponse mapToToppingResponse(Topping topping) {
        return ToppingResponse.builder()
                .id(topping.getId())
                .name(topping.getToppingType().getName())
                .price(topping.getPrice())
                .build();
    }
}
