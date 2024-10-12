package org.payment.bankCheck.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.payment.bankCheck.dtos.CheckDTO;
import org.payment.bankCheck.entities.Check;

@Mapper
public interface CheckMapper {
    CheckMapper INSTANCE = Mappers.getMapper(CheckMapper.class);

    // Mapping de Check vers CheckDTO
    @Mapping(source = "discount.idDiscount", target = "discountId")
    CheckDTO toCheckDTO(Check check);

    // Mapping de CheckDTO vers Check
    @Mapping(source = "discountId", target = "discount.idDiscount")
    Check toCheck(CheckDTO checkDTO);
}
