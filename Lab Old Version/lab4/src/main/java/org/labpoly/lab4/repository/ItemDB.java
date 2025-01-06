package org.labpoly.lab4.repository;

import org.labpoly.lab4.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDB {
    public static List<Item> items = new ArrayList<>();
    static {
        items.add(new Item("1", "Samsung", 10.0, 0));
        items.add(new Item("2", "Nokia 2021", 20.50, 0));
        items.add(new Item("3", "iPhone 20", 90.49, 0));
        items.add(new Item("4", "Motorola", 15.55, 0));
        items.add(new Item("5", "Seamen", 8.99, 0));
    }
}
