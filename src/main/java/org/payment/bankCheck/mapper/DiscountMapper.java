package org.payment.bankCheck.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.payment.bankCheck.dtos.DiscountDTO;
import org.payment.bankCheck.entities.Discount;

@Mapper(uses = CheckMapper.class) // Utilise CheckMapper pour mapper les Check
public interface DiscountMapper {

        DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

        // Mapping de Discount vers DiscountDTO
        @Mapping(target = "checks", source = "checks")
        DiscountDTO toDiscountDTO(Discount discount);

        // Mapping de DiscountDTO vers Discount
        @Mapping(target = "checks", source = "checks")
        Discount toDiscount(DiscountDTO discountDTO);
}
