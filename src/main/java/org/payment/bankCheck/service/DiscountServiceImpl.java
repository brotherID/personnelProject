package org.payment.bankCheck.service;

import org.payment.bankCheck.dtos.DiscountDTO;
import org.payment.bankCheck.entities.Discount;
import org.payment.bankCheck.mapper.DiscountMapper;
import org.payment.bankCheck.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;


    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        discountDTO.setIdDiscount(UUID.randomUUID().toString());
        discountDTO.setDateDiscount(new Date());
        Discount discount = DiscountMapper.INSTANCE.toDiscount(discountDTO);
        return DiscountMapper.INSTANCE.toDiscountDTO(discountRepository.save(discount));
    }

    @Override
    public DiscountDTO getDiscountByIdDiscount(String idDiscount) {

        if (discountRepository.findById(idDiscount).isPresent()) {
            return DiscountMapper.INSTANCE.toDiscountDTO(discountRepository.findById(idDiscount).get());
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Discount discount = Discount.builder()
                .idDiscount("idDiscount")
                .amountDiscount(new BigDecimal(20)).codeBank("codeBank").build();
        DiscountDTO discountDTO = new DiscountDTO();
        for (Field field : discountDTO.getClass().getDeclaredFields()) {
            invokeSetMethod(field.getName(), discountDTO, field.getType(),invokeGetMethod(field.getName(),discount));
        }
        System.out.println(discountDTO);
    }

    private static Object invokeGetMethod(String fieldName, Object object) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        return object.getClass().getMethod("get".concat(fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1)))).invoke(object);
    }

    private static void invokeSetMethod(String fieldName, Object instance ,Class<?> argType, Object arg) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
         instance.getClass().getMethod("set".concat(fieldName.substring(0, 1).toUpperCase().concat(fieldName.substring(1))),argType).invoke(instance,arg);
    }
}
