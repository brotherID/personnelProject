package org.payment.bankCheck.service;

import org.payment.bankCheck.dtos.CheckDTO;
import org.payment.bankCheck.entities.Check;
import org.payment.bankCheck.entities.Discount;
import org.payment.bankCheck.mapper.CheckMapper;
import org.payment.bankCheck.repository.CheckRepository;
import org.payment.bankCheck.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CheckServiceImpl implements  CheckService{

    @Autowired
    private CheckRepository checkRepository;

    @Autowired
    private DiscountRepository discountRepository;


    @Override
    public CheckDTO addCheck(CheckDTO checkDTO ,String idDiscount) {

            Discount discount =  discountRepository.findById(idDiscount).orElseThrow();
            Check check =  CheckMapper.INSTANCE.toCheck(checkDTO);
            check.setDiscount(discount);
            checkRepository.save(check);
            return CheckMapper.INSTANCE.toCheckDTO(check);

    }

    @Override
    public CheckDTO getCheckByIdCheck(String idCheck) {

        if(checkRepository.findById(idCheck).isPresent())
        {
            Check check = checkRepository.findById(idCheck).get();
            return CheckMapper.INSTANCE.toCheckDTO(check);
        }else{
            return null;
        }
    }
}
