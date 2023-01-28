package pja.mas.coffeehouse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import pja.mas.coffeehouse.model.enums.PaymentMethod;

import javax.persistence.Entity;
import java.io.Serial;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends Person{
    @Serial
    private static final long serialVersionUID = 8617370344330231555L;
    private String address;
    private Double wallet;
    private PaymentMethod paymentMethod;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", address='" + address + '\'' +
                ", wallet=" + wallet +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}
