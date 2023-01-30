package pja.mas.coffeehouse.service;

import pja.mas.coffeehouse.dto.beveragerelated.BeverageAndTypeResponse;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageRequest;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageResponse;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageUpdateRequest;

import java.util.List;

public interface BeverageService {
    public List<BeverageResponse> getBeverages();
    public BeverageResponse getBeverageById(Long id);
    public void save(BeverageRequest beverageRequest);
    public void delete(Long id);
    public void update(Long id, BeverageUpdateRequest beverageUpdateRequest);
    public List<BeverageAndTypeResponse> getBeveragesWithTypes();
}
