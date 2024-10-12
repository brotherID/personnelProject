package org.payment.bankCheck.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    private String idDiscount;
    private BigDecimal amountDiscount;
    private Date dateDiscount;
    private String codeBank;
    private List<CheckDTO> checks;  //

}
