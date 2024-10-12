package org.payment.bankCheck.controller;

import org.payment.bankCheck.dtos.CheckDTO;
import org.payment.bankCheck.entities.Check;
import org.payment.bankCheck.repository.CheckRepository;
import org.payment.bankCheck.repository.DiscountRepository;
import org.payment.bankCheck.service.CheckService;
import org.payment.bankCheck.service.DiscountService;
import org.payment.bankCheck.service.FondAndFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="bank")
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CheckController {

    private List<Check> checks = new ArrayList<>();

    @Autowired
    private CheckService checkService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private  CheckRepository checkRepository;

    @Autowired
    private DiscountRepository discountRepository;


    private final FondAndFormService fondAndFormService;

    public  CheckController(FondAndFormService fondAndFormService)
    {
        this.fondAndFormService=fondAndFormService;
    }


    @GetMapping(value="get/amount")
    public String getAmountCheck(){

        return fondAndFormService.getAmount();
    }


    @PostMapping(value="add/check")
    public  ResponseEntity<?>  addCheck(@RequestBody CheckDTO checkDTO , @RequestParam(name = "idDiscount") String idDiscount){

        if(discountService.getDiscountByIdDiscount(idDiscount)!=null)
        {
            return ResponseEntity.created(URI.create("get/check/"+checkService.addCheck(checkDTO,idDiscount).getIdCheck())).body("check added successfully");
        }else{
            return ResponseEntity.badRequest().body("iddiscount inexistant");
        }
    }


    @GetMapping(value="user/get/check/{idCheck}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getCheckByIdCheck(@PathVariable(value = "idCheck") String idCheck){

        if(checkService.getCheckByIdCheck(idCheck)!=null){
            return  ResponseEntity.ok(checkService.getCheckByIdCheck(idCheck));
        }else{
            return  ResponseEntity.badRequest().body("check inexistent");
        }

    }



//    @PostMapping("/check")
//    public ResponseEntity<String> createCheck(@RequestBody Check check) {
//
//        boolean isPresent = checks.stream().anyMatch(i -> i.getIdCheck().equals(check.getIdCheck()));
//        if(!isPresent)
//        {
//            checks.add(check);
//            return ResponseEntity.created(URI.create("get/check/".concat(check.getIdCheck()))).build(); // Retourne HTTP 200 OK
//
//        }else {
//            return ResponseEntity.badRequest().build(); // Retourne HTTP 200 OK
//
//        }
//
//
//        //return new ResponseEntity<>("",headers, HttpStatus.CREATED); // Retourne HTTP 200 OK
//
//
//    }


}
