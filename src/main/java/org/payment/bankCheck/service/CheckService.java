package org.payment.bankCheck.service;

import org.payment.bankCheck.dtos.CheckDTO;

public interface CheckService {

    CheckDTO addCheck(CheckDTO checkDTO, String idDiscount);
    CheckDTO getCheckByIdCheck(String idCheck);

}
