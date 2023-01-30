package pja.mas.coffeehouse.dto.coffeerelated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pja.mas.coffeehouse.model.enums.MilkType;
import pja.mas.coffeehouse.model.enums.Size;
import pja.mas.coffeehouse.model.enums.SugarType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeAndTypeResponse {
    private Long id;
    private String name;
    private Double price;
    private MilkType milkType;
    private SugarType sugarType;
    private Size size;
}
