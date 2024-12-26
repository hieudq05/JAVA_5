package org.labpoly.lab4.service;

import org.labpoly.lab4.model.Item;
import org.labpoly.lab4.repository.ItemDB;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {
    Item add(Item item);

    Item remove(String id);

    Item update(String id, int quantity);

    void clear();

    Map<String, Item> getAll();

    Integer getCount();

    Double getTotal();
}
