package com.example.restapi.controller;

import com.example.restapi.model.ShoppingCartDTO;
import com.example.restapi.sevice.Shop;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ShopController {

    private Shop shopService;

    @GetMapping
    public ShoppingCartDTO calculationUserBasket(ShoppingCartDTO userCart){
        return shopService.calculationUserBasket(userCart);
    }

}
