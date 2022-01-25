package com.example.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties
public class ItemDTO {

    /**
     * Идетификатор товара
     */
    private int id;

    /**
     * Количестов товаров
     */
    private int count;

    /**
     * Стоимость
     */
    private float price;

}
