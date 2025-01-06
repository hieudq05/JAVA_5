package org.labpoly.lab4.service;

import org.labpoly.lab4.model.Item;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class ShoppingCartServiceImp implements ShoppingCartService {
    Map<String, Item> cartItems = new HashMap<>();

    @Override
    public Item add(Item item) {
        cartItems.put(item.getId(), item);
        return item;
    }

    @Override
    public Item remove(String id) {
        Item item = cartItems.get(id);
        cartItems.remove(id);
        return item;
    }

    @Override
    public Item update(String id, int quantity) {
        Item item = cartItems.get(id);
        item.setQty(item.getQty() + quantity);
        cartItems.put(id, item);
        return item;
    }

    @Override
    public void clear() {
        cartItems.clear();
    }

    @Override
    public Map<String, Item> getAll() {
        return cartItems;
    }

    @Override
    public Integer getCount() {
        int count = 0;
        for (Item item : cartItems.values()) {
            count += item.getQty();
        }
        return count;
    }

    @Override
    public Double getTotal() {
        double total = 0.0;
        for (Item item : cartItems.values()) {
            total += item.getQty()*item.getPrice();
        }
        return total;
    }
}
