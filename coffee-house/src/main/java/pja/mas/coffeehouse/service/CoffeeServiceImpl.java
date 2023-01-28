package pja.mas.coffeehouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pja.mas.coffeehouse.dto.CoffeeRequest;
import pja.mas.coffeehouse.dto.CoffeeResponse;
import pja.mas.coffeehouse.dto.CoffeeUpdateRequest;
import pja.mas.coffeehouse.exception.CoffeeNotFoundException;
import pja.mas.coffeehouse.model.enums.MilkType;
import pja.mas.coffeehouse.model.enums.SugarType;
import pja.mas.coffeehouse.model.products.Coffee;
import pja.mas.coffeehouse.repository.CoffeeRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeServiceImpl implements CoffeeService{

    private final CoffeeRepository coffeeRepository;

    @Override
    public List<CoffeeResponse> getCoffees() {
        List<Coffee> coffees = coffeeRepository.findAll();
        log.info("Customers are retrieved {} ", coffees);
        return coffees.stream().map(this::mapToCoffeeResponse).toList();
    }

    @Override
    public CoffeeResponse getCoffeeById(Long id) {
        log.info("Coffee is retrieved {} ", id);
        return coffeeRepository.findById(id)
                .map(this::mapToCoffeeResponse)
                .orElseThrow(() -> new CoffeeNotFoundException(id));
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
                .size(null)
                .milkType(coffeeUpdateRequest.getMilkType())
                .sugarType(coffeeUpdateRequest.getSugarType())
                .build();

        coffeeRepository.save(coffee);
    }

    private Coffee findById(Long id){
        return coffeeRepository
                .findById(id)
                .orElseThrow(() -> new CoffeeNotFoundException(id));
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
}