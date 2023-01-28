package pja.mas.coffeehouse.model.products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;
import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Beverage extends Product{
    @Serial
    private static final long serialVersionUID = 5877118244642681440L;
    private boolean ice;
}
