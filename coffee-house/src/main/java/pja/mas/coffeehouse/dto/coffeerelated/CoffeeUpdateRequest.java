package pja.mas.coffeehouse.dto.coffeerelated;

import pja.mas.coffeehouse.model.enums.MilkType;
import pja.mas.coffeehouse.model.enums.Size;
import pja.mas.coffeehouse.model.enums.SugarType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeUpdateRequest {
    private Double price;
    private boolean onStock;
    private MilkType milkType;
    private SugarType sugarType;
    private Size size;
}
