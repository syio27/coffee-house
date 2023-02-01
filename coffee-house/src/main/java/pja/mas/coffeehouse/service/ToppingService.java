package pja.mas.coffeehouse.service;

import pja.mas.coffeehouse.dto.coffeerelated.ToppingResponse;
import java.util.List;

public interface ToppingService {
    public List<ToppingResponse> getToppingsWithTypes();
    public ToppingResponse getToppingByIdWithType(Long id);
    public List<ToppingResponse> getToppingsByCoffeeId(Long id);
}
