package com.kalu.flo.service;

import com.kalu.flo.controller.dto.FinishPurchaseRequest;

public interface PurchaseService {

    Integer finishPurchase(FinishPurchaseRequest request);
}
