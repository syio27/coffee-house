package pja.mas.coffeehouse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageAndTypeResponse;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageRequest;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageResponse;
import pja.mas.coffeehouse.dto.beveragerelated.BeverageUpdateRequest;
import pja.mas.coffeehouse.exception.ProductNotFoundException;
import pja.mas.coffeehouse.model.products.Beverage;
import pja.mas.coffeehouse.repository.BeverageRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BeverageServiceImpl implements BeverageService{

    private final BeverageRepository beverageRepository;

    @Override
    public List<BeverageResponse> getBeverages() {
        List<Beverage> beverages = beverageRepository.findAll();
        log.info("Customers are retrieved {} ", beverages);
        return beverages.stream().map(this::mapToBeverageResponse).toList();
    }

    @Override
    public BeverageResponse getBeverageById(Long id) {
        log.info("Beverage is retrieved {} ", id);
        return beverageRepository.findById(id)
                .map(this::mapToBeverageResponse)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public void save(BeverageRequest beverageRequest) {
        Beverage beverage = Beverage.builder()
                .price(beverageRequest.getPrice())
                .onStock(true)
                .size(null)
                .ice(true)
                .build();

        log.info("Beverage {}'s details is saved ", beverage.getId());
        beverageRepository.save(beverage);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        beverageRepository.deleteById(id);
    }

    @Override
    public void update(Long id, BeverageUpdateRequest beverageUpdateRequest) {
        Beverage beverage = Beverage.builder()
                .id(id)
                .price(beverageUpdateRequest.getPrice())
                .onStock(beverageUpdateRequest.isOnStock())
                .size(beverageUpdateRequest.getSize())
                .ice(true)
                .build();

        beverageRepository.save(beverage);
    }

    @Override
    public List<BeverageAndTypeResponse> getBeveragesWithTypes() {
        List<Beverage> beverages = beverageRepository.findBeverageAndType();
        log.info("Beverages with types are retrieved {} ", beverages);
        return beverages.stream().map(this::mapToBeverageAndTypeResponse).toList();
    }

    private Beverage findById(Long id){
        return beverageRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    private BeverageResponse mapToBeverageResponse(Beverage beverage) {
        return BeverageResponse.builder()
                .id(beverage.getId())
                .price(beverage.getPrice())
                .size(beverage.getSize())
                .ice(beverage.isIce())
                .build();
    }

    private BeverageAndTypeResponse mapToBeverageAndTypeResponse(Beverage beverage) {
        return BeverageAndTypeResponse.builder()
                .id(beverage.getId())
                .name(beverage.getBeverageType().getName())
                .price(beverage.getPrice())
                .size(beverage.getSize())
                .ice(beverage.isIce())
                .build();
    }
}
