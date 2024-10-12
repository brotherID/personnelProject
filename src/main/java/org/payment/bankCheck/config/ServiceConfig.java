package org.payment.bankCheck.config;

import org.payment.bankCheck.service.AmountService;
import org.payment.bankCheck.service.FondAndFormService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/********
 *
 *
 * desactivation de la configuartion des beans
 *
 */

//@Configuration
public class ServiceConfig
{
    //@Bean
    public FondAndFormService fondAndFormService(AmountService amoutService){
        return new FondAndFormService(amoutService);
    }


    //@Bean
    public AmountService amountService(){
        return  new AmountService();
    }

}
