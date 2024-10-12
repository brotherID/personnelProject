package org.payment.bankCheck.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckDTO {

    private String idCheck;
    private String cmc7;
    private String amount;
    private String discountId;  // Lié à DiscountDTO
}
