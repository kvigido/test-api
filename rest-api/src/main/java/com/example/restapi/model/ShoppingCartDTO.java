package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
@JsonIgnoreProperties
public class ShoppingCartDTO {

    /**
     * Товары
     */
    private List<ItemDTO> items;

    /**
     * Тип оплаты
     */
    private String paymentType;

    /**
     * Идентификатор адреса из адресной книги пользователя
     */
    private int addressId;

    /**
     * Cумма по позиции
     */
    private float sumByPosition;
    /**
     * Общая сумма
     */
    private float totalSum;
}
