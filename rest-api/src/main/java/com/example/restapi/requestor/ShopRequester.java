package com.example.restapi.requestor;

import java.util.Optional;

public interface ShopRequester {

    /**
     * Получить сумму товара из стороннего микросервиса
     * @param id
     * @return
     */
    Float getItemPriceFromOtherService(int id);


}
