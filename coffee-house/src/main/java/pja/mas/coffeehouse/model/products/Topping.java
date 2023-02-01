package pja.mas.coffeehouse.model.products;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topping implements Serializable {

    @Serial
    private static final long serialVersionUID = -3977808147376899335L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double price;

    @OneToOne
    @JoinColumn(name = "topping_type_id")
    private ToppingType toppingType;
    @ManyToOne
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;
}
