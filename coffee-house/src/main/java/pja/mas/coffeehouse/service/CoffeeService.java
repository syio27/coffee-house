package pja.mas.coffeehouse.service;

import pja.mas.coffeehouse.dto.*;

import java.util.List;

public interface CoffeeService {
    public List<CoffeeResponse> getCoffees();
    public CoffeeResponse getCoffeeById(Long id);
    public void save(CoffeeRequest coffeeRequest);
    public void delete(Long id);
    public void update(Long id, CoffeeUpdateRequest coffeeUpdateRequest);

}
