package pja.mas.coffeehouse.model.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pja.mas.coffeehouse.model.enums.MilkType;
import pja.mas.coffeehouse.model.enums.SugarType;

import javax.persistence.*;
import java.io.Serial;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Coffee extends Product{
    @Serial
    private static final long serialVersionUID = 5205931536984856835L;
    private MilkType milkType;
    private SugarType sugarType;
    @OneToOne
    @JoinColumn(name = "coffee_type_id")
    private CoffeeType coffeeType;
    @OneToMany(mappedBy = "coffee", cascade = CascadeType.ALL)
    private List<Topping> toppings;
}
