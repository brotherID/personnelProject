package org.payment.bankCheck.controller;

import org.payment.bankCheck.dtos.DiscountDTO;
import org.payment.bankCheck.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping(value="bank")
public class DiscountController {

    @Autowired
    private DiscountService discountService;


    @GetMapping(value = "/admin/get/discount")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getDiscountByIdDiscount(@RequestParam(name = "idDiscount") String idDiscount)
    {
           if(discountService.getDiscountByIdDiscount(idDiscount)!=null)
           {
               return  ResponseEntity.ok(discountService.getDiscountByIdDiscount(idDiscount));
           }else{
               return  ResponseEntity.noContent().build();
           }
    }


    @PostMapping(value = "/add/discount")
    public ResponseEntity<?> createDiscount(@RequestBody DiscountDTO discountDTO )
    {
        DiscountDTO discountDTOReturned = discountService.createDiscount(discountDTO);
        return ResponseEntity.created(URI.create("/get/discount?idDiscount="+discountDTOReturned.getIdDiscount())).body("discount added successfully");
    }


}
