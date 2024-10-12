package org.payment.bankCheck.service;

public class FondAndFormService {

    private final AmountService amoutService;

    public FondAndFormService(AmountService amoutService){
        this.amoutService=amoutService;
    }


    public String getAmount(){

        return amoutService.getAmout();
    }
}
