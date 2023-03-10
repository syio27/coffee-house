package pja.mas.coffeehouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pja.mas.coffeehouse.dto.coffeerelated.*;
import pja.mas.coffeehouse.exception.ProductNotFoundException;
import pja.mas.coffeehouse.model.enums.MilkType;
import pja.mas.coffeehouse.model.enums.SugarType;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.repository.CoffeeRepository;
import pja.mas.coffeehouse.repository.ToppingRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeRepository coffeeRepository;
    private final ToppingService toppingService;

    @Override
    public List<CoffeeResponse> getCoffees() {
        List<Coffee> coffees = coffeeRepository.findAll();
        log.info("Coffees are retrieved {} ", coffees);
        return coffees.stream().map(this::mapToCoffeeResponse).toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Long id) {
        log.info("Coffee is retrieved {} ", id);
        return coffeeRepository.findById(id)
                .map(this::mapToCoffeeResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public void save(CoffeeRequest coffeeRequest) {
        Coffee coffee = Coffee.builder()
                .price(coffeeRequest.getPrice())
                .onStock(true)
                .size(null)
                .milkType(MilkType.REGULAR)
                .sugarType(SugarType.NO)
                .build();

        log.info("Coffee {}'s details is saved ", coffee.getId());
        coffeeRepository.save(coffee);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        coffeeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, CoffeeUpdateRequest coffeeUpdateRequest) {
        Coffee coffee = Coffee.builder()
                .id(id)
                .price(coffeeUpdateRequest.getPrice())
                .onStock(coffeeUpdateRequest.isOnStock())
                .size(coffeeUpdateRequest.getSize())
                .milkType(coffeeUpdateRequest.getMilkType())
                .sugarType(coffeeUpdateRequest.getSugarType())
                .build();

        coffeeRepository.save(coffee);
    }

    @Override
    public List<CoffeeAndTypeResponse> getCoffeesWithTypes() {
        List<Coffee> coffees = coffeeRepository.findCoffeesWithTypes();
        log.info("Coffees with types are retrieved {} ", coffees);
        return coffees.stream().map(this::mapToCoffeeAndTypeResponse).toList();
    }

    @Override
    public CoffeeAndTypeResponse getCoffeeByIdWithType (Long id) {
        Coffee coffee = coffeeRepository.findCoffeeByIdWithType(id);
        CoffeeAndTypeResponse coffeeAndTypeResponse = mapToCoffeeAndTypeResponse(coffee);
        log.info("Coffee {} with type retrieved {}", id, coffeeAndTypeResponse);
        return coffeeAndTypeResponse;
    }

    @Override
    public CoffeeAndTypeToppingsResponse getCoffeeFullDetails(Long id) {
        Coffee coffee = coffeeRepository.findCoffeeByIdWithType(id);
        log.info("Passed Coffee id {}, received coffee id {}", id, coffee.getId());
        return mapToCoffeeAndTypeToppingsResponse(coffee);
    }


    private Coffee findById(Long id){
        return coffeeRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private CoffeeAndTypeToppingsResponse mapToCoffeeAndTypeToppingsResponse(Coffee coffee){
        return CoffeeAndTypeToppingsResponse.builder()
                .id(coffee.getId())
                .name(coffee.getCoffeeType().getName())
                .price(coffee.getPrice())
                .milkType(coffee.getMilkType())
                .sugarType(coffee.getSugarType())
                .size(coffee.getSize())
                .toppingResponseList(toppingService.getToppingsByCoffeeId(coffee.getId()))
                .build();
    }

    private CoffeeResponse mapToCoffeeResponse(Coffee coffee) {
        return CoffeeResponse.builder()
                .id(coffee.getId())
                .price(coffee.getPrice())
                .milkType(coffee.getMilkType())
                .sugarType(coffee.getSugarType())
                .size(coffee.getSize())
                .build();
    }

    private CoffeeAndTypeResponse mapToCoffeeAndTypeResponse(Coffee coffee) {
        return CoffeeAndTypeResponse.builder()
                .id(coffee.getId())
                .name(coffee.getCoffeeType().getName())
                .price(coffee.getPrice())
                .size(coffee.getSize())
                .build();
    }
}
