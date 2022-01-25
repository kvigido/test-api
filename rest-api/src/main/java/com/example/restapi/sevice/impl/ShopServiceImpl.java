package com.example.restapi.sevice.impl;

import com.example.restapi.model.ItemDTO;
import com.example.restapi.model.ShoppingCartDTO;
import com.example.restapi.requestor.ShopRequester;
import com.example.restapi.sevice.Shop;
import lombok.RequiredArgsConstructor;
import org.ehcache.Cache;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements Shop {

    private final ShopRequester shopRequester;
    private final Cache<Integer, Float> cachePriceItem;


    @Override
    public ShoppingCartDTO calculationUserBasket(ShoppingCartDTO shoppingCartDTO) {
        ShoppingCartDTO countedCard = new ShoppingCartDTO();
        countedCard.setItems(countedCard.getItems().stream().map(itemDTO -> culcPriceSumForItem(itemDTO)).collect(Collectors.toList()));
        countedCard.setTotalSum(countTotalSum(countedCard.getItems()));
        return countedCard;
    }

    private float countTotalSum(List<ItemDTO> items) {
        Float totalSum = 0f;
        for(ItemDTO item : items){
            totalSum = totalSum + item.getPrice();
        }
        return totalSum;
    }

    /**
     * Расчет суммы по товару.
     * @param item
     * @return
     */
    private ItemDTO culcPriceSumForItem(ItemDTO item){
        item.setPrice(getPrice(item.getId()) * item.getCount());
        return item;
    }

    /**
     * Получить стоимость товара
     * Берем из Кэша
     * Если в Кэше Нет
     * Делаем запрос к стороннему микросервису
     * @param id
     * @return
     */
    private Float getPrice(int id){
        Float price = cachePriceItem.get(id);
        return price != null ? price : shopRequester.getItemPriceFromOtherService(id);
    }
}
