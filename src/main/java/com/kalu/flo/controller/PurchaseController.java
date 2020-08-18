package com.kalu.flo.controller;

import com.kalu.flo.controller.dto.FinishPurchaseRequest;
import com.kalu.flo.controller.dto.FinishPurchaseResponse;
import com.kalu.flo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }


    @PostMapping("/finishPurchase")
    public ResponseEntity finishPurchase(@Validated @RequestBody FinishPurchaseRequest request){
        Integer orderId = purchaseService.finishPurchase(request);
        return ResponseEntity.ok(new FinishPurchaseResponse(orderId));
    }
}
