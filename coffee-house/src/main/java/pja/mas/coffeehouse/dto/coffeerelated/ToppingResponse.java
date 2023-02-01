package pja.mas.coffeehouse.dto.coffeerelated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToppingResponse{
    private Long id;
    private String name;
    private Double price;
}
