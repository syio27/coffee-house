package pja.mas.coffeehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pja.mas.coffeehouse.model.enums.PaymentMethod;
import pja.mas.coffeehouse.model.enums.Sex;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Sex sex;
    private String address;
    private PaymentMethod paymentMethod;
}
