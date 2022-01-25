package com.example.restapi.sevice;


import com.example.restapi.model.ShoppingCartDTO;

public interface Shop {

    ShoppingCartDTO calculationUserBasket(ShoppingCartDTO shoppingCartDTO);

}
