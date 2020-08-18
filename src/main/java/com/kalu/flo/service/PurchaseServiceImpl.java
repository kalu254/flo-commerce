package com.kalu.flo.service;

import com.kalu.flo.controller.dto.FinishPurchaseRequest;
import com.kalu.flo.exceptions.NotFoundException;
import com.kalu.flo.model.OrderEntity;
import com.kalu.flo.model.ProductEntity;
import com.kalu.flo.model.PurchaseItemEntity;
import com.kalu.flo.repository.OrderEntityRepository;
import com.kalu.flo.repository.PurchaseItemEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PurchaseServiceImpl  implements  PurchaseService{

    private final ProductService productService;
    private final UserService userService;
    private final OrderEntityRepository orderEntityRepository;
    private final PurchaseItemEntityRepository purchaseItemEntityRepository;

    @Autowired
    public PurchaseServiceImpl(ProductService productService, UserService userService, OrderEntityRepository orderEntityRepository, PurchaseItemEntityRepository purchaseItemEntityRepository) {
        this.productService = productService;
        this.userService = userService;
        this.orderEntityRepository = orderEntityRepository;
        this.purchaseItemEntityRepository = purchaseItemEntityRepository;
    }

    @Override
    public Integer finishPurchase(FinishPurchaseRequest request) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserEntity(userService.findOrCreateUser(request.getUserName(),
                                                               request.getUserSurname(),
                                                               request.getEmail(),
                                                               request.getPhone(),
                                                               request.getAddress() ));
        orderEntity.setComment(request.getComment());
        orderEntity = orderEntityRepository.save(orderEntity);

        for (Map.Entry<Integer, Integer> entry : request.getProductIdProductCount().entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            try {
                ProductEntity productEntity = productService.findById(k);
                PurchaseItemEntity p = new PurchaseItemEntity();
                p.setProductEntity(productEntity);
                p.setCount(v);
                p.setOrderEntity(orderEntity);

                purchaseItemEntityRepository.save(p);

            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }

        return orderEntity.getId();
    }
}
