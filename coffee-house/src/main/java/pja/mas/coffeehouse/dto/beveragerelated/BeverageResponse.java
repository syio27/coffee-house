package pja.mas.coffeehouse.dto.beveragerelated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pja.mas.coffeehouse.model.enums.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeverageResponse {
    private Long id;
    private Double price;
    private Size size;
    private boolean ice;
}
