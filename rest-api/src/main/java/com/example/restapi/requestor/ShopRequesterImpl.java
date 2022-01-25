package com.example.restapi.requestor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShopRequesterImpl implements ShopRequester {

    @Override
    public Float getItemPriceFromOtherService(int id) {
        //Метод возвращает стоимость товара.
        return null;
    }
}
