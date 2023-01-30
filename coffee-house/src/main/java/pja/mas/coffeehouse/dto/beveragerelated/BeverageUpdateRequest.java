package pja.mas.coffeehouse.dto.beveragerelated;

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
public class BeverageUpdateRequest {
    private Double price;
    private boolean onStock;
    private Size size;
}
